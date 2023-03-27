package io.littlehorse.common.model.objectId;

import com.google.protobuf.Message;
import io.littlehorse.common.model.ObjectId;
import io.littlehorse.common.model.metrics.WfSpecMetrics;
import io.littlehorse.common.proto.GETableClassEnumPb;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.jlib.common.proto.MetricsWindowLengthPb;
import io.littlehorse.jlib.common.proto.WfSpecMetricsIdPb;
import io.littlehorse.jlib.common.proto.WfSpecMetricsPb;
import java.util.Date;

public class WfSpecMetricsId
    extends ObjectId<WfSpecMetricsIdPb, WfSpecMetricsPb, WfSpecMetrics> {

    public Date windowStart;
    public MetricsWindowLengthPb windowType;
    public String WfSpecName;

    public String getPartitionKey() {
        return WfSpecName;
    }

    public Class<WfSpecMetricsIdPb> getProtoBaseClass() {
        return WfSpecMetricsIdPb.class;
    }

    public WfSpecMetricsId() {}

    public WfSpecMetricsId(
        Date windowStart,
        MetricsWindowLengthPb type,
        String wfSpecName
    ) {
        this.windowStart = windowStart;
        this.windowType = type;
        this.WfSpecName = wfSpecName;
    }

    public void initFrom(Message proto) {
        WfSpecMetricsIdPb p = (WfSpecMetricsIdPb) proto;
        WfSpecName = p.getWfSpecName();
        windowType = p.getWindowType();
        windowStart = LHUtil.fromProtoTs(p.getWindowStart());
    }

    public WfSpecMetricsIdPb.Builder toProto() {
        WfSpecMetricsIdPb.Builder out = WfSpecMetricsIdPb
            .newBuilder()
            .setWfSpecName(WfSpecName)
            .setWindowType(windowType)
            .setWindowStart(LHUtil.fromDate(windowStart));
        return out;
    }

    public String getStoreKey() {
        return LHUtil.getCompositeId(
            windowType.toString(),
            LHUtil.toLhDbFormat(windowStart),
            WfSpecName
        );
    }

    public void initFrom(String storeKey) {
        String[] split = storeKey.split("/");
        windowType = MetricsWindowLengthPb.valueOf(split[0]);
        windowStart = new Date(Long.valueOf(split[1]));
        WfSpecName = split[2];
    }

    public GETableClassEnumPb getType() {
        return GETableClassEnumPb.TASK_DEF_METRICS;
    }
}
