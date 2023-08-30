package io.littlehorse.common.model.corecommand.subcommand;

import com.google.protobuf.Message;
import io.grpc.Status;
import io.littlehorse.common.LHServerConfig;
import io.littlehorse.common.dao.CoreProcessorDAO;
import io.littlehorse.common.exceptions.LHApiException;
import io.littlehorse.common.model.corecommand.SubCommand;
import io.littlehorse.common.model.getable.core.variable.VariableValueModel;
import io.littlehorse.common.model.getable.core.wfrun.WfRunModel;
import io.littlehorse.common.model.getable.global.wfspec.WfSpecModel;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.sdk.common.proto.RunWfRequest;
import io.littlehorse.sdk.common.proto.VariableValue;
import io.littlehorse.sdk.common.proto.WfRun;
import java.util.HashMap;
import java.util.Map;

public class RunWfRequestModel extends SubCommand<RunWfRequest> {

    public String wfSpecName;
    public Integer wfSpecVersion;
    public Map<String, VariableValueModel> variables;
    public String id;

    public String getPartitionKey() {
        if (id == null) {
            id = LHUtil.generateGuid();
        }
        return id;
    }

    public Class<RunWfRequest> getProtoBaseClass() {
        return RunWfRequest.class;
    }

    public RunWfRequestModel() {
        variables = new HashMap<>();
    }

    public RunWfRequest.Builder toProto() {
        RunWfRequest.Builder out = RunWfRequest.newBuilder().setWfSpecName(wfSpecName);
        if (id != null) out.setId(id);
        if (wfSpecVersion != null) out.setWfSpecVersion(wfSpecVersion);

        for (Map.Entry<String, VariableValueModel> e : variables.entrySet()) {
            out.putVariables(e.getKey(), e.getValue().toProto().build());
        }
        return out;
    }

    public void initFrom(Message proto) {
        RunWfRequest p = (RunWfRequest) proto;
        wfSpecName = p.getWfSpecName();
        if (p.hasId()) id = p.getId();
        if (p.hasWfSpecVersion()) wfSpecVersion = p.getWfSpecVersion();

        for (Map.Entry<String, VariableValue> e : p.getVariablesMap().entrySet()) {
            variables.put(e.getKey(), VariableValueModel.fromProto(e.getValue()));
        }
    }

    public boolean hasResponse() {
        return true;
    }

    public WfRun process(CoreProcessorDAO dao, LHServerConfig config) {
        WfSpecModel spec = dao.getWfSpec(wfSpecName, wfSpecVersion);
        if (spec == null) {
            throw new LHApiException(Status.NOT_FOUND, "Couldn't find specified WfSpec");
        }

        if (id == null) {
            id = LHUtil.generateGuid();
        } else {
            WfRunModel oldWfRun = dao.getWfRun(id);
            if (oldWfRun != null) {
                throw new LHApiException(Status.ALREADY_EXISTS, "WfRun with id " + id + " already exists!");
            }
        }

        // TODO: Add WfRun Start Metrics

        WfRunModel newRun = spec.startNewRun(this);
        newRun.advance(dao.getEventTime());

        return newRun.toProto().build();
    }

    public static RunWfRequestModel fromProto(RunWfRequest p) {
        RunWfRequestModel out = new RunWfRequestModel();
        out.initFrom(p);
        return out;
    }
}