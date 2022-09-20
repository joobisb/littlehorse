// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lh_proto.proto

package io.littlehorse.common.proto;

/**
 * Protobuf type {@code lh_proto.TaskResultEventPb}
 */
public final class TaskResultEventPb extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:lh_proto.TaskResultEventPb)
    TaskResultEventPbOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TaskResultEventPb.newBuilder() to construct.
  private TaskResultEventPb(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TaskResultEventPb() {
    resultCode_ = 0;
    logOutput_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TaskResultEventPb();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private TaskResultEventPb(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (time_ != null) {
              subBuilder = time_.toBuilder();
            }
            time_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(time_);
              time_ = subBuilder.buildPartial();
            }

            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            resultCode_ = rawValue;
            break;
          }
          case 50: {
            io.littlehorse.common.proto.VariableValuePb.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) != 0)) {
              subBuilder = output_.toBuilder();
            }
            output_ = input.readMessage(io.littlehorse.common.proto.VariableValuePb.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(output_);
              output_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 58: {
            bitField0_ |= 0x00000002;
            logOutput_ = input.readBytes();
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
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultEventPb_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultEventPb_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.common.proto.TaskResultEventPb.class, io.littlehorse.common.proto.TaskResultEventPb.Builder.class);
  }

  private int bitField0_;
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

  public static final int TIME_FIELD_NUMBER = 4;
  private com.google.protobuf.Timestamp time_;
  /**
   * <code>.google.protobuf.Timestamp time = 4;</code>
   * @return Whether the time field is set.
   */
  @java.lang.Override
  public boolean hasTime() {
    return time_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp time = 4;</code>
   * @return The time.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getTime() {
    return time_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : time_;
  }
  /**
   * <code>.google.protobuf.Timestamp time = 4;</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getTimeOrBuilder() {
    return getTime();
  }

  public static final int RESULT_CODE_FIELD_NUMBER = 5;
  private int resultCode_;
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
   * @return The enum numeric value on the wire for resultCode.
   */
  @java.lang.Override public int getResultCodeValue() {
    return resultCode_;
  }
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
   * @return The resultCode.
   */
  @java.lang.Override public io.littlehorse.common.proto.TaskResultCodePb getResultCode() {
    @SuppressWarnings("deprecation")
    io.littlehorse.common.proto.TaskResultCodePb result = io.littlehorse.common.proto.TaskResultCodePb.valueOf(resultCode_);
    return result == null ? io.littlehorse.common.proto.TaskResultCodePb.UNRECOGNIZED : result;
  }

  public static final int OUTPUT_FIELD_NUMBER = 6;
  private io.littlehorse.common.proto.VariableValuePb output_;
  /**
   * <code>.lh_proto.VariableValuePb output = 6;</code>
   * @return Whether the output field is set.
   */
  @java.lang.Override
  public boolean hasOutput() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.lh_proto.VariableValuePb output = 6;</code>
   * @return The output.
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableValuePb getOutput() {
    return output_ == null ? io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : output_;
  }
  /**
   * <code>.lh_proto.VariableValuePb output = 6;</code>
   */
  @java.lang.Override
  public io.littlehorse.common.proto.VariableValuePbOrBuilder getOutputOrBuilder() {
    return output_ == null ? io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : output_;
  }

  public static final int LOG_OUTPUT_FIELD_NUMBER = 7;
  private com.google.protobuf.ByteString logOutput_;
  /**
   * <code>bytes log_output = 7;</code>
   * @return Whether the logOutput field is set.
   */
  @java.lang.Override
  public boolean hasLogOutput() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>bytes log_output = 7;</code>
   * @return The logOutput.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getLogOutput() {
    return logOutput_;
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
    if (time_ != null) {
      output.writeMessage(4, getTime());
    }
    if (resultCode_ != io.littlehorse.common.proto.TaskResultCodePb.SUCCESS.getNumber()) {
      output.writeEnum(5, resultCode_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(6, getOutput());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeBytes(7, logOutput_);
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
    if (time_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getTime());
    }
    if (resultCode_ != io.littlehorse.common.proto.TaskResultCodePb.SUCCESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, resultCode_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getOutput());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(7, logOutput_);
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
    if (!(obj instanceof io.littlehorse.common.proto.TaskResultEventPb)) {
      return super.equals(obj);
    }
    io.littlehorse.common.proto.TaskResultEventPb other = (io.littlehorse.common.proto.TaskResultEventPb) obj;

    if (getThreadRunNumber()
        != other.getThreadRunNumber()) return false;
    if (getTaskRunNumber()
        != other.getTaskRunNumber()) return false;
    if (getTaskRunPosition()
        != other.getTaskRunPosition()) return false;
    if (hasTime() != other.hasTime()) return false;
    if (hasTime()) {
      if (!getTime()
          .equals(other.getTime())) return false;
    }
    if (resultCode_ != other.resultCode_) return false;
    if (hasOutput() != other.hasOutput()) return false;
    if (hasOutput()) {
      if (!getOutput()
          .equals(other.getOutput())) return false;
    }
    if (hasLogOutput() != other.hasLogOutput()) return false;
    if (hasLogOutput()) {
      if (!getLogOutput()
          .equals(other.getLogOutput())) return false;
    }
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
    if (hasTime()) {
      hash = (37 * hash) + TIME_FIELD_NUMBER;
      hash = (53 * hash) + getTime().hashCode();
    }
    hash = (37 * hash) + RESULT_CODE_FIELD_NUMBER;
    hash = (53 * hash) + resultCode_;
    if (hasOutput()) {
      hash = (37 * hash) + OUTPUT_FIELD_NUMBER;
      hash = (53 * hash) + getOutput().hashCode();
    }
    if (hasLogOutput()) {
      hash = (37 * hash) + LOG_OUTPUT_FIELD_NUMBER;
      hash = (53 * hash) + getLogOutput().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.common.proto.TaskResultEventPb parseFrom(
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
  public static Builder newBuilder(io.littlehorse.common.proto.TaskResultEventPb prototype) {
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
   * Protobuf type {@code lh_proto.TaskResultEventPb}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:lh_proto.TaskResultEventPb)
      io.littlehorse.common.proto.TaskResultEventPbOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultEventPb_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultEventPb_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.common.proto.TaskResultEventPb.class, io.littlehorse.common.proto.TaskResultEventPb.Builder.class);
    }

    // Construct using io.littlehorse.common.proto.TaskResultEventPb.newBuilder()
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
        getOutputFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      threadRunNumber_ = 0;

      taskRunNumber_ = 0;

      taskRunPosition_ = 0;

      if (timeBuilder_ == null) {
        time_ = null;
      } else {
        time_ = null;
        timeBuilder_ = null;
      }
      resultCode_ = 0;

      if (outputBuilder_ == null) {
        output_ = null;
      } else {
        outputBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      logOutput_ = com.google.protobuf.ByteString.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.common.proto.LhProto.internal_static_lh_proto_TaskResultEventPb_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultEventPb getDefaultInstanceForType() {
      return io.littlehorse.common.proto.TaskResultEventPb.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultEventPb build() {
      io.littlehorse.common.proto.TaskResultEventPb result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultEventPb buildPartial() {
      io.littlehorse.common.proto.TaskResultEventPb result = new io.littlehorse.common.proto.TaskResultEventPb(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.threadRunNumber_ = threadRunNumber_;
      result.taskRunNumber_ = taskRunNumber_;
      result.taskRunPosition_ = taskRunPosition_;
      if (timeBuilder_ == null) {
        result.time_ = time_;
      } else {
        result.time_ = timeBuilder_.build();
      }
      result.resultCode_ = resultCode_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        if (outputBuilder_ == null) {
          result.output_ = output_;
        } else {
          result.output_ = outputBuilder_.build();
        }
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        to_bitField0_ |= 0x00000002;
      }
      result.logOutput_ = logOutput_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof io.littlehorse.common.proto.TaskResultEventPb) {
        return mergeFrom((io.littlehorse.common.proto.TaskResultEventPb)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.common.proto.TaskResultEventPb other) {
      if (other == io.littlehorse.common.proto.TaskResultEventPb.getDefaultInstance()) return this;
      if (other.getThreadRunNumber() != 0) {
        setThreadRunNumber(other.getThreadRunNumber());
      }
      if (other.getTaskRunNumber() != 0) {
        setTaskRunNumber(other.getTaskRunNumber());
      }
      if (other.getTaskRunPosition() != 0) {
        setTaskRunPosition(other.getTaskRunPosition());
      }
      if (other.hasTime()) {
        mergeTime(other.getTime());
      }
      if (other.resultCode_ != 0) {
        setResultCodeValue(other.getResultCodeValue());
      }
      if (other.hasOutput()) {
        mergeOutput(other.getOutput());
      }
      if (other.hasLogOutput()) {
        setLogOutput(other.getLogOutput());
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
      io.littlehorse.common.proto.TaskResultEventPb parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.littlehorse.common.proto.TaskResultEventPb) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

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

    private com.google.protobuf.Timestamp time_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> timeBuilder_;
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     * @return Whether the time field is set.
     */
    public boolean hasTime() {
      return timeBuilder_ != null || time_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     * @return The time.
     */
    public com.google.protobuf.Timestamp getTime() {
      if (timeBuilder_ == null) {
        return time_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : time_;
      } else {
        return timeBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    public Builder setTime(com.google.protobuf.Timestamp value) {
      if (timeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        time_ = value;
        onChanged();
      } else {
        timeBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    public Builder setTime(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (timeBuilder_ == null) {
        time_ = builderForValue.build();
        onChanged();
      } else {
        timeBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    public Builder mergeTime(com.google.protobuf.Timestamp value) {
      if (timeBuilder_ == null) {
        if (time_ != null) {
          time_ =
            com.google.protobuf.Timestamp.newBuilder(time_).mergeFrom(value).buildPartial();
        } else {
          time_ = value;
        }
        onChanged();
      } else {
        timeBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    public Builder clearTime() {
      if (timeBuilder_ == null) {
        time_ = null;
        onChanged();
      } else {
        time_ = null;
        timeBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    public com.google.protobuf.Timestamp.Builder getTimeBuilder() {
      
      onChanged();
      return getTimeFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getTimeOrBuilder() {
      if (timeBuilder_ != null) {
        return timeBuilder_.getMessageOrBuilder();
      } else {
        return time_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : time_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp time = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getTimeFieldBuilder() {
      if (timeBuilder_ == null) {
        timeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getTime(),
                getParentForChildren(),
                isClean());
        time_ = null;
      }
      return timeBuilder_;
    }

    private int resultCode_ = 0;
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
     * @return The enum numeric value on the wire for resultCode.
     */
    @java.lang.Override public int getResultCodeValue() {
      return resultCode_;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
     * @param value The enum numeric value on the wire for resultCode to set.
     * @return This builder for chaining.
     */
    public Builder setResultCodeValue(int value) {
      
      resultCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
     * @return The resultCode.
     */
    @java.lang.Override
    public io.littlehorse.common.proto.TaskResultCodePb getResultCode() {
      @SuppressWarnings("deprecation")
      io.littlehorse.common.proto.TaskResultCodePb result = io.littlehorse.common.proto.TaskResultCodePb.valueOf(resultCode_);
      return result == null ? io.littlehorse.common.proto.TaskResultCodePb.UNRECOGNIZED : result;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
     * @param value The resultCode to set.
     * @return This builder for chaining.
     */
    public Builder setResultCode(io.littlehorse.common.proto.TaskResultCodePb value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      resultCode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.lh_proto.TaskResultCodePb result_code = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearResultCode() {
      
      resultCode_ = 0;
      onChanged();
      return this;
    }

    private io.littlehorse.common.proto.VariableValuePb output_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableValuePb, io.littlehorse.common.proto.VariableValuePb.Builder, io.littlehorse.common.proto.VariableValuePbOrBuilder> outputBuilder_;
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     * @return Whether the output field is set.
     */
    public boolean hasOutput() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     * @return The output.
     */
    public io.littlehorse.common.proto.VariableValuePb getOutput() {
      if (outputBuilder_ == null) {
        return output_ == null ? io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : output_;
      } else {
        return outputBuilder_.getMessage();
      }
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    public Builder setOutput(io.littlehorse.common.proto.VariableValuePb value) {
      if (outputBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        output_ = value;
        onChanged();
      } else {
        outputBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    public Builder setOutput(
        io.littlehorse.common.proto.VariableValuePb.Builder builderForValue) {
      if (outputBuilder_ == null) {
        output_ = builderForValue.build();
        onChanged();
      } else {
        outputBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    public Builder mergeOutput(io.littlehorse.common.proto.VariableValuePb value) {
      if (outputBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
            output_ != null &&
            output_ != io.littlehorse.common.proto.VariableValuePb.getDefaultInstance()) {
          output_ =
            io.littlehorse.common.proto.VariableValuePb.newBuilder(output_).mergeFrom(value).buildPartial();
        } else {
          output_ = value;
        }
        onChanged();
      } else {
        outputBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    public Builder clearOutput() {
      if (outputBuilder_ == null) {
        output_ = null;
        onChanged();
      } else {
        outputBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    public io.littlehorse.common.proto.VariableValuePb.Builder getOutputBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getOutputFieldBuilder().getBuilder();
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    public io.littlehorse.common.proto.VariableValuePbOrBuilder getOutputOrBuilder() {
      if (outputBuilder_ != null) {
        return outputBuilder_.getMessageOrBuilder();
      } else {
        return output_ == null ?
            io.littlehorse.common.proto.VariableValuePb.getDefaultInstance() : output_;
      }
    }
    /**
     * <code>.lh_proto.VariableValuePb output = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.littlehorse.common.proto.VariableValuePb, io.littlehorse.common.proto.VariableValuePb.Builder, io.littlehorse.common.proto.VariableValuePbOrBuilder> 
        getOutputFieldBuilder() {
      if (outputBuilder_ == null) {
        outputBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.littlehorse.common.proto.VariableValuePb, io.littlehorse.common.proto.VariableValuePb.Builder, io.littlehorse.common.proto.VariableValuePbOrBuilder>(
                getOutput(),
                getParentForChildren(),
                isClean());
        output_ = null;
      }
      return outputBuilder_;
    }

    private com.google.protobuf.ByteString logOutput_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes log_output = 7;</code>
     * @return Whether the logOutput field is set.
     */
    @java.lang.Override
    public boolean hasLogOutput() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>bytes log_output = 7;</code>
     * @return The logOutput.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getLogOutput() {
      return logOutput_;
    }
    /**
     * <code>bytes log_output = 7;</code>
     * @param value The logOutput to set.
     * @return This builder for chaining.
     */
    public Builder setLogOutput(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
      logOutput_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes log_output = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearLogOutput() {
      bitField0_ = (bitField0_ & ~0x00000002);
      logOutput_ = getDefaultInstance().getLogOutput();
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


    // @@protoc_insertion_point(builder_scope:lh_proto.TaskResultEventPb)
  }

  // @@protoc_insertion_point(class_scope:lh_proto.TaskResultEventPb)
  private static final io.littlehorse.common.proto.TaskResultEventPb DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.common.proto.TaskResultEventPb();
  }

  public static io.littlehorse.common.proto.TaskResultEventPb getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TaskResultEventPb>
      PARSER = new com.google.protobuf.AbstractParser<TaskResultEventPb>() {
    @java.lang.Override
    public TaskResultEventPb parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new TaskResultEventPb(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<TaskResultEventPb> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TaskResultEventPb> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.common.proto.TaskResultEventPb getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

