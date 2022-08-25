// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: observability.proto

package io.littlehorse.common.proto.observability;

/**
 * Protobuf type {@code lh_proto.TaskStartOePb}
 */
public final class TaskStartOePb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.TaskStartOePb)
    TaskStartOePbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskStartOePb.newBuilder() to construct.
  private TaskStartOePb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskStartOePb() {
    nodeName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskStartOePb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskStartOePb(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            threadRunNumber_ = input.readInt32();
            break;
          }
          case 16: {

            taskRunNumber_ = input.readInt32();
            break;
          }
          case 24: {

            taskRunPosition_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            nodeName_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.common.proto.observability.Observability.internal_static_lh_proto_TaskStartOePb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.observability.Observability.internal_static_lh_proto_TaskStartOePb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.observability.TaskStartOePb.class, io.littlehorse.common.proto.observability.TaskStartOePb.Builder.class);
  }

  public static final int THREAD_RUN_NUMBER_FIELD_NUMBER = 1;
  private int threadRunNumber_;
  /**
   * <code>int32 thread_run_number = 1;</code>
   * @return The threadRunNumber.
   */
  @java.lang.Override
  public int getThreadRunNumber() {
    return threadRunNumber_;
  }

  public static final int TASK_RUN_NUMBER_FIELD_NUMBER = 2;
  private int taskRunNumber_;
  /**
   * <code>int32 task_run_number = 2;</code>
   * @return The taskRunNumber.
   */
  @java.lang.Override
  public int getTaskRunNumber() {
    return taskRunNumber_;
  }

  public static final int TASK_RUN_POSITION_FIELD_NUMBER = 3;
  private int taskRunPosition_;
  /**
   * <code>int32 task_run_position = 3;</code>
   * @return The taskRunPosition.
   */
  @java.lang.Override
  public int getTaskRunPosition() {
    return taskRunPosition_;
  }

  public static final int NODE_NAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object nodeName_;
  /**
   * <code>string node_name = 4;</code>
   * @return The nodeName.
   */
  @java.lang.Override
  public java.lang.String getNodeName() {
    java.lang.Object ref = nodeName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nodeName_ = s;
      return s;
    }
  }
  /**
   * <code>string node_name = 4;</code>
   * @return The bytes for nodeName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNodeNameBytes() {
    java.lang.Object ref = nodeName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nodeName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (threadRunNumber_ != 0) {
      output.writeInt32(1, threadRunNumber_);
    }
    if (taskRunNumber_ != 0) {
      output.writeInt32(2, taskRunNumber_);
    }
    if (taskRunPosition_ != 0) {
      output.writeInt32(3, taskRunPosition_);
    }
    if (!getNodeNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, nodeName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (threadRunNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, threadRunNumber_);
    }
    if (taskRunNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, taskRunNumber_);
    }
    if (taskRunPosition_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, taskRunPosition_);
    }
    if (!getNodeNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, nodeName_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.littlehorse.common.proto.observability.TaskStartOePb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.observability.TaskStartOePb other = (io.littlehorse.common.proto.observability.TaskStartOePb) obj;

    if (getThreadRunNumber()
        != other.getThreadRunNumber()) return false;
    if (getTaskRunNumber()
        != other.getTaskRunNumber()) return false;
    if (getTaskRunPosition()
        != other.getTaskRunPosition()) return false;
    if (!getNodeName()
        .equals(other.getNodeName())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + THREAD_RUN_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getThreadRunNumber();
    hash = (37 * hash) + TASK_RUN_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getTaskRunNumber();
    hash = (37 * hash) + TASK_RUN_POSITION_FIELD_NUMBER;
    hash = (53 * hash) + getTaskRunPosition();
    hash = (37 * hash) + NODE_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getNodeName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.observability.TaskStartOePb parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.littlehorse.common.proto.observability.TaskStartOePb prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code lh_proto.TaskStartOePb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.TaskStartOePb)
      io.littlehorse.common.proto.observability.TaskStartOePbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.observability.Observability.internal_static_lh_proto_TaskStartOePb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.observability.Observability.internal_static_lh_proto_TaskStartOePb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.observability.TaskStartOePb.class, io.littlehorse.common.proto.observability.TaskStartOePb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.observability.TaskStartOePb.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      threadRunNumber_ = 0;

      taskRunNumber_ = 0;

      taskRunPosition_ = 0;

      nodeName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.observability.Observability.internal_static_lh_proto_TaskStartOePb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.observability.TaskStartOePb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.observability.TaskStartOePb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.observability.TaskStartOePb build() {
      io.littlehorse.common.proto.observability.TaskStartOePb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.observability.TaskStartOePb buildPartial() {
      io.littlehorse.common.proto.observability.TaskStartOePb result = new io.littlehorse.common.proto.observability.TaskStartOePb(this);
      result.threadRunNumber_ = threadRunNumber_;
      result.taskRunNumber_ = taskRunNumber_;
      result.taskRunPosition_ = taskRunPosition_;
      result.nodeName_ = nodeName_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.littlehorse.common.proto.observability.TaskStartOePb) {
        return mergeFrom((io.littlehorse.common.proto.observability.TaskStartOePb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.observability.TaskStartOePb other) {
      if (other == io.littlehorse.common.proto.observability.TaskStartOePb.getDefaultInstance()) return this;
      if (other.getThreadRunNumber() != 0) {
        setThreadRunNumber(other.getThreadRunNumber());
      }
      if (other.getTaskRunNumber() != 0) {
        setTaskRunNumber(other.getTaskRunNumber());
      }
      if (other.getTaskRunPosition() != 0) {
        setTaskRunPosition(other.getTaskRunPosition());
      }
      if (!other.getNodeName().isEmpty()) {
        nodeName_ = other.nodeName_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.littlehorse.common.proto.observability.TaskStartOePb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.observability.TaskStartOePb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int threadRunNumber_ ;
    /**
     * <code>int32 thread_run_number = 1;</code>
     * @return The threadRunNumber.
     */
    @java.lang.Override
    public int getThreadRunNumber() {
      return threadRunNumber_;
    }
    /**
     * <code>int32 thread_run_number = 1;</code>
     * @param value The threadRunNumber to set.
     * @return This builder for chaining.
     */
    public Builder setThreadRunNumber(int value) {
      
      threadRunNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 thread_run_number = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearThreadRunNumber() {
      
      threadRunNumber_ = 0;
      onChanged();
      return this;
    }

    private int taskRunNumber_ ;
    /**
     * <code>int32 task_run_number = 2;</code>
     * @return The taskRunNumber.
     */
    @java.lang.Override
    public int getTaskRunNumber() {
      return taskRunNumber_;
    }
    /**
     * <code>int32 task_run_number = 2;</code>
     * @param value The taskRunNumber to set.
     * @return This builder for chaining.
     */
    public Builder setTaskRunNumber(int value) {
      
      taskRunNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 task_run_number = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTaskRunNumber() {
      
      taskRunNumber_ = 0;
      onChanged();
      return this;
    }

    private int taskRunPosition_ ;
    /**
     * <code>int32 task_run_position = 3;</code>
     * @return The taskRunPosition.
     */
    @java.lang.Override
    public int getTaskRunPosition() {
      return taskRunPosition_;
    }
    /**
     * <code>int32 task_run_position = 3;</code>
     * @param value The taskRunPosition to set.
     * @return This builder for chaining.
     */
    public Builder setTaskRunPosition(int value) {
      
      taskRunPosition_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 task_run_position = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearTaskRunPosition() {
      
      taskRunPosition_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object nodeName_ = "";
    /**
     * <code>string node_name = 4;</code>
     * @return The nodeName.
     */
    public java.lang.String getNodeName() {
      java.lang.Object ref = nodeName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nodeName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string node_name = 4;</code>
     * @return The bytes for nodeName.
     */
    public com.google.protobuf.ByteString
        getNodeNameBytes() {
      java.lang.Object ref = nodeName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nodeName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string node_name = 4;</code>
     * @param value The nodeName to set.
     * @return This builder for chaining.
     */
    public Builder setNodeName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nodeName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string node_name = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearNodeName() {
      
      nodeName_ = getDefaultInstance().getNodeName();
      onChanged();
      return this;
    }
    /**
     * <code>string node_name = 4;</code>
     * @param value The bytes for nodeName to set.
     * @return This builder for chaining.
     */
    public Builder setNodeNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nodeName_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:lh_proto.TaskStartOePb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.TaskStartOePb)
  private static final io.littlehorse.common.proto.observability.TaskStartOePb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.observability.TaskStartOePb();
  }

  public static io.littlehorse.common.proto.observability.TaskStartOePb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskStartOePb>
      PARSER = new com.google.protobuf.AbstractParser<TaskStartOePb>() {
    @java.lang.Override
    public TaskStartOePb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TaskStartOePb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskStartOePb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskStartOePb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.observability.TaskStartOePb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
