package io.littlehorse.common.model.meta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.protobuf.MessageOrBuilder;
import io.littlehorse.common.LHConstants;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.proto.FailureHandlerDefPb;
import io.littlehorse.common.proto.FailureHandlerDefPbOrBuilder;
import io.littlehorse.common.util.LHUtil;

public class FailureHandlerDef extends LHSerializable<FailureHandlerDefPb> {

    public String specificFailure;
    public String handlerSpecName;

    @JsonIgnore
    public Node node;

    public FailureHandlerDef() {}

    public Class<FailureHandlerDefPb> getProtoBaseClass() {
        return FailureHandlerDefPb.class;
    }

    public FailureHandlerDefPb.Builder toProto() {
        FailureHandlerDefPb.Builder out = FailureHandlerDefPb
            .newBuilder()
            .setHandlerSpecName(handlerSpecName);

        if (specificFailure != null) out.setSpecificFailure(specificFailure);

        return out;
    }

    public void initFrom(MessageOrBuilder proto) {
        FailureHandlerDefPbOrBuilder p = (FailureHandlerDefPbOrBuilder) proto;
        if (p.hasSpecificFailure()) specificFailure = p.getSpecificFailure();
        handlerSpecName = p.getHandlerSpecName();
    }

    public static FailureHandlerDef fromProto(FailureHandlerDefPbOrBuilder p) {
        FailureHandlerDef out = new FailureHandlerDef();
        out.initFrom(p);
        return out;
    }

    public boolean doesHandle(String failureName) {
        if (specificFailure == null) {
            // Then it's a wildcard, which means match all exceptions.
            LHUtil.log("wildcard exception handler...accepting.");
            return true;
        }

        if (specificFailure.equals(failureName)) {
            LHUtil.log("Exact match exception handler");
            return true;
        }

        LHUtil.log("Specific: ", this.specificFailure, " handling: " + failureName);

        if (specificFailure.equals(LHConstants.VAR_ERROR)) {
            return (
                failureName.equals(LHConstants.VAR_MUTATION_ERROR) ||
                failureName.equals(LHConstants.VAR_SUB_ERROR)
            );
        }

        if (specificFailure.equals(LHConstants.VAR_ERROR)) {
            return (
                failureName.equals(LHConstants.VAR_MUTATION_ERROR) ||
                failureName.equals(LHConstants.VAR_SUB_ERROR)
            );
        }

        if (specificFailure.equals(LHConstants.TASK_ERROR)) {
            return (
                failureName.equals(LHConstants.TASK_FAILURE) ||
                failureName.equals(LHConstants.TIMEOUT)
            );
        }

        return false;
    }
}