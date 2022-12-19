package io.littlehorse.common.model.command;

import com.google.protobuf.MessageOrBuilder;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.command.subcommand.DeleteWfRun;
import io.littlehorse.common.model.command.subcommand.PutExternalEvent;
import io.littlehorse.common.model.command.subcommand.PutExternalEventDef;
import io.littlehorse.common.model.command.subcommand.PutTaskDef;
import io.littlehorse.common.model.command.subcommand.PutWfSpec;
import io.littlehorse.common.model.command.subcommand.ResumeWfRun;
import io.littlehorse.common.model.command.subcommand.RunWf;
import io.littlehorse.common.model.command.subcommand.SleepNodeMatured;
import io.littlehorse.common.model.command.subcommand.StopWfRun;
import io.littlehorse.common.model.command.subcommand.TaskClaimEvent;
import io.littlehorse.common.model.command.subcommand.TaskResultEvent;
import io.littlehorse.common.proto.CommandPb;
import io.littlehorse.common.proto.CommandPb.CommandCase;
import io.littlehorse.common.proto.CommandPbOrBuilder;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.server.streamsimpl.coreprocessors.KafkaStreamsLHDAOImpl;
import java.util.Date;

public class Command extends LHSerializable<CommandPb> {

    public String commandId;
    public Date time;

    public CommandCase type;
    public TaskResultEvent taskResultEvent;
    public TaskClaimEvent taskClaimEvent;
    public PutExternalEvent putExternalEvent;
    public PutWfSpec putWfSpec;
    public PutTaskDef putTaskDef;
    public PutExternalEventDef putExternalEventDef;
    public RunWf runWf;
    public StopWfRun stopWfRun;
    public ResumeWfRun resumeWfRun;
    public SleepNodeMatured sleepNodeMatured;
    public DeleteWfRun deleteWfRun;

    public Class<CommandPb> getProtoBaseClass() {
        return CommandPb.class;
    }

    public Command() {}

    public Command(SubCommand<?> cmd) {
        this.commandId = LHUtil.generateGuid();
        this.time = new Date();
        this.setSubCommand(cmd);
    }

    public CommandPb.Builder toProto() {
        CommandPb.Builder out = CommandPb.newBuilder();
        out.setTime(LHUtil.fromDate(time));

        if (commandId != null) {
            out.setCommandId(commandId);
        }

        switch (type) {
            case TASK_RESULT_EVENT:
                out.setTaskResultEvent(taskResultEvent.toProto());
                break;
            case TASK_CLAIM_EVENT:
                out.setTaskClaimEvent(taskClaimEvent.toProto());
                break;
            case PUT_EXTERNAL_EVENT:
                out.setPutExternalEvent(putExternalEvent.toProto());
                break;
            case PUT_WF_SPEC:
                out.setPutWfSpec(putWfSpec.toProto());
                break;
            case PUT_TASK_DEF:
                out.setPutTaskDef(putTaskDef.toProto());
                break;
            case PUT_EXTERNAL_EVENT_DEF:
                out.setPutExternalEventDef(putExternalEventDef.toProto());
                break;
            case RUN_WF:
                out.setRunWf(runWf.toProto());
                break;
            case STOP_WF_RUN:
                out.setStopWfRun(stopWfRun.toProto());
                break;
            case RESUME_WF_RUN:
                out.setResumeWfRun(resumeWfRun.toProto());
                break;
            case SLEEP_NODE_MATURED:
                out.setSleepNodeMatured(sleepNodeMatured.toProto());
                break;
            case DELETE_WF_RUN:
                out.setDeleteWfRun(deleteWfRun.toProto());
                break;
            case COMMAND_NOT_SET:
                throw new RuntimeException("Not possible");
        }
        return out;
    }

    public void initFrom(MessageOrBuilder proto) {
        CommandPbOrBuilder p = (CommandPbOrBuilder) proto;
        time = LHUtil.fromProtoTs(p.getTime());

        if (p.hasCommandId()) {
            commandId = p.getCommandId();
        }

        type = p.getCommandCase();
        switch (type) {
            case TASK_RESULT_EVENT:
                taskResultEvent = TaskResultEvent.fromProto(p.getTaskResultEvent());
                break;
            case TASK_CLAIM_EVENT:
                taskClaimEvent =
                    TaskClaimEvent.fromProto(p.getTaskClaimEventOrBuilder());
                break;
            case PUT_EXTERNAL_EVENT:
                putExternalEvent =
                    PutExternalEvent.fromProto(p.getPutExternalEventOrBuilder());
                break;
            case PUT_WF_SPEC:
                putWfSpec = PutWfSpec.fromProto(p.getPutWfSpecOrBuilder());
                break;
            case PUT_TASK_DEF:
                putTaskDef = PutTaskDef.fromProto(p.getPutTaskDefOrBuilder());
                break;
            case PUT_EXTERNAL_EVENT_DEF:
                putExternalEventDef =
                    PutExternalEventDef.fromProto(
                        p.getPutExternalEventDefOrBuilder()
                    );
                break;
            case RUN_WF:
                runWf = RunWf.fromProto(p.getRunWfOrBuilder());
                break;
            case STOP_WF_RUN:
                stopWfRun = StopWfRun.fromProto(p.getStopWfRunOrBuilder());
                break;
            case RESUME_WF_RUN:
                resumeWfRun = ResumeWfRun.fromProto(p.getResumeWfRunOrBuilder());
                break;
            case SLEEP_NODE_MATURED:
                sleepNodeMatured =
                    SleepNodeMatured.fromProto(p.getSleepNodeMaturedOrBuilder());
                break;
            case DELETE_WF_RUN:
                deleteWfRun = DeleteWfRun.fromProto(p.getDeleteWfRunOrBuilder());
                break;
            case COMMAND_NOT_SET:
                throw new RuntimeException("Not possible");
        }
    }

    public SubCommand<?> getSubCommand() {
        switch (type) {
            case TASK_RESULT_EVENT:
                return taskResultEvent;
            case TASK_CLAIM_EVENT:
                return taskClaimEvent;
            case PUT_EXTERNAL_EVENT:
                return putExternalEvent;
            case PUT_WF_SPEC:
                return putWfSpec;
            case PUT_TASK_DEF:
                return putTaskDef;
            case PUT_EXTERNAL_EVENT_DEF:
                return putExternalEventDef;
            case RUN_WF:
                return runWf;
            case STOP_WF_RUN:
                return stopWfRun;
            case RESUME_WF_RUN:
                return resumeWfRun;
            case SLEEP_NODE_MATURED:
                return sleepNodeMatured;
            case DELETE_WF_RUN:
                return deleteWfRun;
            case COMMAND_NOT_SET:
        }
        throw new RuntimeException("Not possible");
    }

    public void setSubCommand(SubCommand<?> cmd) {
        Class<?> cls = cmd.getClass();
        if (cls.equals(PutTaskDef.class)) {
            type = CommandCase.PUT_TASK_DEF;
            putTaskDef = (PutTaskDef) cmd;
        } else if (cls.equals(PutExternalEventDef.class)) {
            type = CommandCase.PUT_EXTERNAL_EVENT_DEF;
            putExternalEventDef = (PutExternalEventDef) cmd;
        } else if (cls.equals(PutWfSpec.class)) {
            type = CommandCase.PUT_WF_SPEC;
            putWfSpec = (PutWfSpec) cmd;
        } else if (cls.equals(RunWf.class)) {
            type = CommandCase.RUN_WF;
            runWf = (RunWf) cmd;
        } else if (cls.equals(PutExternalEvent.class)) {
            type = CommandCase.PUT_EXTERNAL_EVENT;
            putExternalEvent = (PutExternalEvent) cmd;
        } else if (cls.equals(TaskResultEvent.class)) {
            type = CommandCase.TASK_RESULT_EVENT;
            taskResultEvent = (TaskResultEvent) cmd;
        } else if (cls.equals(TaskClaimEvent.class)) {
            type = CommandCase.TASK_CLAIM_EVENT;
            taskClaimEvent = (TaskClaimEvent) cmd;
        } else if (cls.equals(StopWfRun.class)) {
            type = CommandCase.STOP_WF_RUN;
            stopWfRun = (StopWfRun) cmd;
        } else if (cls.equals(ResumeWfRun.class)) {
            type = CommandCase.RESUME_WF_RUN;
            resumeWfRun = (ResumeWfRun) cmd;
        } else if (cls.equals(SleepNodeMatured.class)) {
            type = CommandCase.SLEEP_NODE_MATURED;
            sleepNodeMatured = (SleepNodeMatured) cmd;
        } else if (cls.equals(DeleteWfRun.class)) {
            type = CommandCase.DELETE_WF_RUN;
            deleteWfRun = (DeleteWfRun) cmd;
        } else {
            throw new RuntimeException("Unrecognized class: " + cls.getName());
        }
    }

    public String getPartitionKey() {
        return getSubCommand().getPartitionKey();
    }

    public boolean hasResponse() {
        return getSubCommand().hasResponse();
    }

    public AbstractResponse<?> process(KafkaStreamsLHDAOImpl dao, LHConfig config) {
        return getSubCommand().process(dao, config);
    }
}
