// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

/**
 * <pre>
 * Stuff for Index (internal to the store)
 * </pre>
 *
 * Protobuf enum {@code littlehorse.GETableClassEnumPb}
 */
public enum GETableClassEnumPb
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>TASK_DEF = 0;</code>
   */
  TASK_DEF(0),
  /**
   * <code>EXTERNAL_EVENT_DEF = 1;</code>
   */
  EXTERNAL_EVENT_DEF(1),
  /**
   * <code>WF_SPEC = 2;</code>
   */
  WF_SPEC(2),
  /**
   * <code>WF_RUN = 3;</code>
   */
  WF_RUN(3),
  /**
   * <code>NODE_RUN = 4;</code>
   */
  NODE_RUN(4),
  /**
   * <code>VARIABLE = 5;</code>
   */
  VARIABLE(5),
  /**
   * <code>EXTERNAL_EVENT = 6;</code>
   */
  EXTERNAL_EVENT(6),
  /**
   * <code>TASK_DEF_METRICS = 7;</code>
   */
  TASK_DEF_METRICS(7),
  /**
   * <code>WF_SPEC_METRICS = 8;</code>
   */
  WF_SPEC_METRICS(8),
  /**
   * <code>TASK_WORKER_GROUP = 9;</code>
   */
  TASK_WORKER_GROUP(9),
  /**
   * <code>USER_TASK_DEF = 10;</code>
   */
  USER_TASK_DEF(10),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>TASK_DEF = 0;</code>
   */
  public static final int TASK_DEF_VALUE = 0;
  /**
   * <code>EXTERNAL_EVENT_DEF = 1;</code>
   */
  public static final int EXTERNAL_EVENT_DEF_VALUE = 1;
  /**
   * <code>WF_SPEC = 2;</code>
   */
  public static final int WF_SPEC_VALUE = 2;
  /**
   * <code>WF_RUN = 3;</code>
   */
  public static final int WF_RUN_VALUE = 3;
  /**
   * <code>NODE_RUN = 4;</code>
   */
  public static final int NODE_RUN_VALUE = 4;
  /**
   * <code>VARIABLE = 5;</code>
   */
  public static final int VARIABLE_VALUE = 5;
  /**
   * <code>EXTERNAL_EVENT = 6;</code>
   */
  public static final int EXTERNAL_EVENT_VALUE = 6;
  /**
   * <code>TASK_DEF_METRICS = 7;</code>
   */
  public static final int TASK_DEF_METRICS_VALUE = 7;
  /**
   * <code>WF_SPEC_METRICS = 8;</code>
   */
  public static final int WF_SPEC_METRICS_VALUE = 8;
  /**
   * <code>TASK_WORKER_GROUP = 9;</code>
   */
  public static final int TASK_WORKER_GROUP_VALUE = 9;
  /**
   * <code>USER_TASK_DEF = 10;</code>
   */
  public static final int USER_TASK_DEF_VALUE = 10;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static GETableClassEnumPb valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static GETableClassEnumPb forNumber(int value) {
    switch (value) {
      case 0: return TASK_DEF;
      case 1: return EXTERNAL_EVENT_DEF;
      case 2: return WF_SPEC;
      case 3: return WF_RUN;
      case 4: return NODE_RUN;
      case 5: return VARIABLE;
      case 6: return EXTERNAL_EVENT;
      case 7: return TASK_DEF_METRICS;
      case 8: return WF_SPEC_METRICS;
      case 9: return TASK_WORKER_GROUP;
      case 10: return USER_TASK_DEF;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<GETableClassEnumPb>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      GETableClassEnumPb> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<GETableClassEnumPb>() {
          public GETableClassEnumPb findValueByNumber(int number) {
            return GETableClassEnumPb.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return io.littlehorse.common.proto.InternalServer.getDescriptor().getEnumTypes().get(2);
  }

  private static final GETableClassEnumPb[] VALUES = values();

  public static GETableClassEnumPb valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private GETableClassEnumPb(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:littlehorse.GETableClassEnumPb)
}

