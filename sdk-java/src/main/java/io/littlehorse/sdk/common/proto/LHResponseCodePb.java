// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

/**
 * Protobuf enum {@code littlehorse.LHResponseCodePb}
 */
public enum LHResponseCodePb
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>OK = 0;</code>
   */
  OK(0),
  /**
   * <code>CONNECTION_ERROR = 1;</code>
   */
  CONNECTION_ERROR(1),
  /**
   * <code>NOT_FOUND_ERROR = 2;</code>
   */
  NOT_FOUND_ERROR(2),
  /**
   * <code>BAD_REQUEST_ERROR = 3;</code>
   */
  BAD_REQUEST_ERROR(3),
  /**
   * <code>VALIDATION_ERROR = 4;</code>
   */
  VALIDATION_ERROR(4),
  /**
   * <code>ALREADY_EXISTS_ERROR = 5;</code>
   */
  ALREADY_EXISTS_ERROR(5),
  /**
   * <code>REPORTED_BUT_NOT_PROCESSED = 6;</code>
   */
  REPORTED_BUT_NOT_PROCESSED(6),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>OK = 0;</code>
   */
  public static final int OK_VALUE = 0;
  /**
   * <code>CONNECTION_ERROR = 1;</code>
   */
  public static final int CONNECTION_ERROR_VALUE = 1;
  /**
   * <code>NOT_FOUND_ERROR = 2;</code>
   */
  public static final int NOT_FOUND_ERROR_VALUE = 2;
  /**
   * <code>BAD_REQUEST_ERROR = 3;</code>
   */
  public static final int BAD_REQUEST_ERROR_VALUE = 3;
  /**
   * <code>VALIDATION_ERROR = 4;</code>
   */
  public static final int VALIDATION_ERROR_VALUE = 4;
  /**
   * <code>ALREADY_EXISTS_ERROR = 5;</code>
   */
  public static final int ALREADY_EXISTS_ERROR_VALUE = 5;
  /**
   * <code>REPORTED_BUT_NOT_PROCESSED = 6;</code>
   */
  public static final int REPORTED_BUT_NOT_PROCESSED_VALUE = 6;


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
  public static LHResponseCodePb valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static LHResponseCodePb forNumber(int value) {
    switch (value) {
      case 0: return OK;
      case 1: return CONNECTION_ERROR;
      case 2: return NOT_FOUND_ERROR;
      case 3: return BAD_REQUEST_ERROR;
      case 4: return VALIDATION_ERROR;
      case 5: return ALREADY_EXISTS_ERROR;
      case 6: return REPORTED_BUT_NOT_PROCESSED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<LHResponseCodePb>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      LHResponseCodePb> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<LHResponseCodePb>() {
          public LHResponseCodePb findValueByNumber(int number) {
            return LHResponseCodePb.forNumber(number);
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
    return io.littlehorse.sdk.common.proto.Service.getDescriptor().getEnumTypes().get(0);
  }

  private static final LHResponseCodePb[] VALUES = values();

  public static LHResponseCodePb valueOf(
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

  private LHResponseCodePb(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:littlehorse.LHResponseCodePb)
}
