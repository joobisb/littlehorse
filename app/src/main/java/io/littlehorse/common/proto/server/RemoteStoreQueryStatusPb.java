// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package io.littlehorse.common.proto.server;

/**
 * Protobuf enum {@code lh_proto.RemoteStoreQueryStatusPb}
 */
public enum RemoteStoreQueryStatusPb
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>RSQ_OK = 0;</code>
   */
  RSQ_OK(0),
  /**
   * <code>RSQ_NOT_FOUND = 1;</code>
   */
  RSQ_NOT_FOUND(1),
  /**
   * <code>RSQ_MIGRATED = 2;</code>
   */
  RSQ_MIGRATED(2),
  /**
   * <code>RSQ_NOT_AVAILABLE = 3;</code>
   */
  RSQ_NOT_AVAILABLE(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>RSQ_OK = 0;</code>
   */
  public static final int RSQ_OK_VALUE = 0;
  /**
   * <code>RSQ_NOT_FOUND = 1;</code>
   */
  public static final int RSQ_NOT_FOUND_VALUE = 1;
  /**
   * <code>RSQ_MIGRATED = 2;</code>
   */
  public static final int RSQ_MIGRATED_VALUE = 2;
  /**
   * <code>RSQ_NOT_AVAILABLE = 3;</code>
   */
  public static final int RSQ_NOT_AVAILABLE_VALUE = 3;


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
  public static RemoteStoreQueryStatusPb valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static RemoteStoreQueryStatusPb forNumber(int value) {
    switch (value) {
      case 0: return RSQ_OK;
      case 1: return RSQ_NOT_FOUND;
      case 2: return RSQ_MIGRATED;
      case 3: return RSQ_NOT_AVAILABLE;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<RemoteStoreQueryStatusPb>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      RemoteStoreQueryStatusPb> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<RemoteStoreQueryStatusPb>() {
          public RemoteStoreQueryStatusPb findValueByNumber(int number) {
            return RemoteStoreQueryStatusPb.forNumber(number);
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
    return io.littlehorse.common.proto.server.Server.getDescriptor().getEnumTypes().get(4);
  }

  private static final RemoteStoreQueryStatusPb[] VALUES = values();

  public static RemoteStoreQueryStatusPb valueOf(
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

  private RemoteStoreQueryStatusPb(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:lh_proto.RemoteStoreQueryStatusPb)
}

