package io.littlehorse.server.processors;

import io.littlehorse.common.LHConfig;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.model.GETable;
import io.littlehorse.common.model.GlobalPOSTable;
import io.littlehorse.common.model.meta.Node;
import io.littlehorse.common.model.meta.WfSpec;
import io.littlehorse.common.model.observability.ObservabilityEvent;
import io.littlehorse.common.model.observability.ObservabilityEvents;
import io.littlehorse.common.model.observability.RunStartOe;
import io.littlehorse.common.model.observability.TaskResultOe;
import io.littlehorse.common.model.observability.TaskScheduledOe;
import io.littlehorse.common.model.observability.TaskStartOe;
import io.littlehorse.common.model.observability.ThreadStartOe;
import io.littlehorse.common.model.observability.ThreadStatusChangeOe;
import io.littlehorse.common.model.observability.WfRunStatusChangeOe;
import io.littlehorse.common.model.wfrun.TaskRun;
import io.littlehorse.common.model.wfrun.ThreadRun;
import io.littlehorse.common.model.wfrun.WfRun;
import io.littlehorse.common.proto.LHStatusPb;
import io.littlehorse.common.proto.TaskResultCodePb;
import io.littlehorse.common.util.LHUtil;
import java.util.HashMap;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;

public class WfRunProcessor
    implements Processor<String, ObservabilityEvents, String, GETable<?>> {

    private ProcessorContext<String, GETable<?>> ctx;
    private KeyValueStore<String, WfRun> wfRunStore;
    private KeyValueStore<String, TaskRun> taskRunStore;
    private ReadOnlyKeyValueStore<String, WfSpec> wfSpecStore;
    private HashMap<String, WfSpec> wfSpecCache;

    public WfRunProcessor(LHConfig config) {
        wfSpecCache = new HashMap<>();
    }

    public WfSpec getWfSpec(String id) {
        WfSpec out = wfSpecCache.get(id);
        if (out == null) {
            out = wfSpecStore.get(id);
            wfSpecCache.put(id, out);
        }
        return out;
    }

    @Override
    public void init(final ProcessorContext<String, GETable<?>> ctx) {
        this.ctx = ctx;
        this.wfRunStore = ctx.getStateStore(GETable.getBaseStoreName(WfRun.class));
        this.taskRunStore =
            ctx.getStateStore(GETable.getBaseStoreName(TaskRun.class));
        this.wfSpecStore =
            ctx.getStateStore(GlobalPOSTable.getGlobalStoreName(WfSpec.class));
    }

    public void process(final Record<String, ObservabilityEvents> record) {
        String wfRunId = record.key();
        ObservabilityEvents events = record.value();

        WfRun wfRun = wfRunStore.get(wfRunId);

        for (ObservabilityEvent evt : events.events) {
            switch (evt.type) {
                case RUN_START:
                    wfRun = handleRunStart(wfRunId, evt);
                    break;
                case THREAD_START:
                    handleThreadStart(wfRun, evt);
                    break;
                case TASK_SCHEDULE:
                    handleTaskSchedule(wfRun, evt);
                    break;
                case TASK_START:
                    handleTaskStart(wfRun, evt);
                    break;
                case TASK_RESULT:
                    handleTaskResult(wfRun, evt);
                    break;
                case THREAD_STATUS:
                    handleThreadStatus(wfRun, evt);
                    break;
                case WF_RUN_STATUS:
                    handleWfRunStatus(wfRun, evt);
                    break;
                case EVENT_NOT_SET:
                // Nothing to do
            }
        }
        wfRunStore.put(wfRunId, wfRun);
        forward(wfRun);
    }

    private void forward(GETable<?> getable) {
        Record<String, GETable<?>> newRec = new Record<>(
            getable.getPartitionKey(),
            getable,
            ctx.currentStreamTimeMs()
        );
        newRec
            .headers()
            .add(LHConstants.OBJECT_ID_HEADER, getable.getObjectId().getBytes());
        ctx.forward(newRec);
    }

    private WfRun handleRunStart(String wfRunId, ObservabilityEvent evt) {
        RunStartOe rs = evt.runStart;
        WfRun wfRun = new WfRun();
        wfRun.id = wfRunId;
        wfRun.status = LHStatusPb.RUNNING;
        wfRun.wfSpecId = rs.wfSpecId;
        wfRun.wfSpecName = rs.wfSpecName;
        wfRun.startTime = evt.time;

        return wfRun;
    }

    private void handleThreadStart(WfRun wfRun, ObservabilityEvent evt) {
        ThreadStartOe ts = evt.threadStart;
        ThreadRun thr = new ThreadRun();
        thr.wfRunId = wfRun.id;
        thr.wfSpecId = wfRun.wfSpecId;
        thr.number = wfRun.threadRuns.size();
        thr.status = LHStatusPb.RUNNING;
        thr.threadSpecName = ts.threadSpecName;
        thr.numSteps = 0;
        thr.startTime = evt.time;

        wfRun.threadRuns.add(thr);
    }

    public void handleTaskSchedule(WfRun wfRun, ObservabilityEvent evt) {
        TaskScheduledOe ts = evt.taskSchedule;

        TaskRun task = new TaskRun();
        task.wfRunId = wfRun.id;
        task.threadRunNumber = ts.threadRunNumber;
        task.position = ts.taskRunPosition;

        task.number = ts.taskRunNumber;
        task.attemptNumber = ts.taskRunAttemptNumber;
        task.status = LHStatusPb.STARTING;

        task.scheduleTime = evt.time;

        task.wfSpecId = wfRun.wfSpecId;
        task.wfSpecName = wfRun.wfSpecName;
        task.nodeName = ts.nodeName;

        ThreadRun thread = wfRun.threadRuns.get(task.threadRunNumber);
        thread.numSteps++;
        task.threadSpecName = thread.threadSpecName;

        WfSpec wfSpec = getWfSpec(wfRun.wfSpecId);
        if (wfSpec != null) {
            Node node = wfSpec.threadSpecs
                .get(task.threadSpecName)
                .nodes.get(task.nodeName);
            task.taskDefId = node.taskNode.taskDefName;
        }

        taskRunStore.put(task.getObjectId(), task);
        forward(task);
    }

    private void handleTaskStart(WfRun wfRun, ObservabilityEvent evt) {
        TaskStartOe ts = evt.taskStart;
        TaskRun task = taskRunStore.get(
            TaskRun.getStoreKey(wfRun.id, ts.threadRunNumber, ts.taskRunPosition)
        );

        if (task == null) {
            LHUtil.log("tried to start task which hadn't been created yet ):");
            task = new TaskRun();
            task.wfRunId = wfRun.id;
            task.status = LHStatusPb.RUNNING;
            task.threadRunNumber = ts.threadRunNumber;
            task.position = ts.taskRunPosition;
        }

        task.startTime = evt.time;
        taskRunStore.put(task.getObjectId(), task);
        forward(task);
    }

    private void handleTaskResult(WfRun wfRun, ObservabilityEvent evt) {
        TaskResultOe tc = evt.taskResult;
        TaskRun task = taskRunStore.get(
            TaskRun.getStoreKey(wfRun.id, tc.threadRunNumber, tc.taskRunPosition)
        );

        task.endTime = evt.time;
        task.output = tc.output;
        task.logOutput = tc.logOutput;
        task.status =
            tc.resultCode == TaskResultCodePb.SUCCESS
                ? LHStatusPb.COMPLETED
                : LHStatusPb.ERROR;
        task.resultCode = tc.resultCode;

        taskRunStore.put(task.getObjectId(), task);
        forward(task);
    }

    private void handleThreadStatus(WfRun wfRun, ObservabilityEvent evt) {
        ThreadStatusChangeOe tsc = evt.threadStatus;
        ThreadRun thread = wfRun.threadRuns.get(tsc.threadRunNumber);
        thread.status = tsc.status;
        if (
            thread.status == LHStatusPb.COMPLETED || thread.status == LHStatusPb.ERROR
        ) {
            thread.endTime = evt.time;
        }
    }

    private void handleWfRunStatus(WfRun wfRun, ObservabilityEvent evt) {
        WfRunStatusChangeOe wsc = evt.wfRunStatus;
        wfRun.status = wsc.status;

        if (
            wfRun.status == LHStatusPb.COMPLETED || wfRun.status == LHStatusPb.ERROR
        ) {
            wfRun.endTime = evt.time;
        }
    }
}
