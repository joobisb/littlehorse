package io.littlehorse.common.model.wfrun.subnoderun;

import com.google.protobuf.Message;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.exceptions.LHVarSubError;
import io.littlehorse.common.model.wfrun.Failure;
import io.littlehorse.common.model.wfrun.SubNodeRun;
import io.littlehorse.common.model.wfrun.ThreadRun;
import io.littlehorse.common.model.wfrun.VariableValue;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.jlib.common.proto.LHStatusPb;
import io.littlehorse.jlib.common.proto.TaskResultCodePb;
import io.littlehorse.jlib.common.proto.VariableTypePb;
import io.littlehorse.jlib.common.proto.WaitThreadRunPb;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitThreadRun extends SubNodeRun<WaitThreadRunPb> {

    public Integer threadRunNumber;
    public Date threadEndTime;
    public TaskResultCodePb threadResultCode;
    public LHStatusPb threadStatus;

    public Class<WaitThreadRunPb> getProtoBaseClass() {
        return WaitThreadRunPb.class;
    }

    public void initFrom(Message proto) {
        WaitThreadRunPb p = (WaitThreadRunPb) proto;
        threadRunNumber = p.getThreadRunNumber();
        if (p.hasThreadEndTime()) {
            threadEndTime = LHUtil.fromProtoTs(p.getThreadEndTime());
        }
        if (p.hasThreadResultCode()) {
            threadResultCode = p.getThreadResultCode();
        }
        if (p.hasThreadStatus()) {
            threadStatus = p.getThreadStatus();
        }
    }

    public WaitThreadRunPb.Builder toProto() {
        WaitThreadRunPb.Builder out = WaitThreadRunPb
            .newBuilder()
            .setThreadRunNumber(threadRunNumber);

        if (threadResultCode != null) {
            out.setThreadResultCode(threadResultCode);
        }

        if (threadEndTime != null) {
            out.setThreadEndTime(LHUtil.fromDate(threadEndTime));
        }

        if (threadStatus != null) {
            out.setThreadStatus(threadStatus);
        }

        return out;
    }

    public static WaitThreadRun fromProto(WaitThreadRunPb p) {
        WaitThreadRun out = new WaitThreadRun();
        out.initFrom(p);
        return out;
    }

    public boolean advanceIfPossible(Date time) {
        ThreadRun toWait = getWfRun().threadRuns.get(threadRunNumber);

        threadStatus = toWait.status;
        threadEndTime = toWait.endTime;

        if (toWait.status == LHStatusPb.COMPLETED) {
            VariableValue out = new VariableValue();
            out.type = VariableTypePb.NULL;
            nodeRun.complete(out, time);
            return true;
        } else if (toWait.status == LHStatusPb.ERROR) {
            nodeRun.fail(
                new Failure(
                    TaskResultCodePb.CHILD_FALIED,
                    "Thread failed: " + toWait.errorMessage,
                    LHConstants.CHILD_FAILURE
                ),
                time
            );
            return true;
        } else {
            // nothing to do.
            log.debug("Still waiting for thread");
            return false;
        }
    }

    public void arrive(Date time) {
        try {
            threadRunNumber =
                nodeRun.threadRun
                    .assignVariable(getNode().waitForThreadNode.threadRunNumber)
                    .asInt()
                    .intVal.intValue();
        } catch (LHVarSubError exn) {
            nodeRun.fail(
                new Failure(
                    TaskResultCodePb.VAR_SUB_ERROR,
                    "Failed determining thread run number: " + exn.getMessage(),
                    LHConstants.VAR_SUB_ERROR
                ),
                time
            );
        }

        if (threadRunNumber >= getWfRun().threadRuns.size() || threadRunNumber < 0) {
            nodeRun.fail(
                new Failure(
                    TaskResultCodePb.VAR_SUB_ERROR,
                    "Determined threadrunnumber " + threadRunNumber + " is invalid",
                    LHConstants.VAR_SUB_ERROR
                ),
                time
            );
        }

        ThreadRun toWait = getWfRun().threadRuns.get(threadRunNumber);

        // Validate that we're not waiting on a thread that's above us in the
        // hierarchy
        ThreadRun potentialParent = nodeRun.threadRun;
        while (potentialParent != null) {
            if (potentialParent.number == toWait.number) {
                nodeRun.fail(
                    new Failure(
                        TaskResultCodePb.VAR_SUB_ERROR,
                        "Determined threadrunnumber " +
                        threadRunNumber +
                        " is a parent!",
                        LHConstants.VAR_SUB_ERROR
                    ),
                    time
                );
            }
            potentialParent = potentialParent.getParent();
        }

        threadStatus = toWait.status;
    }
}
