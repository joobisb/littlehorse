// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

public interface ThreadStartOePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.ThreadStartOePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 1;</code>
   */
  int getVariablesCount();
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 1;</code>
   */
  boolean containsVariables(
      java.lang.String key);
  /**
   * Use {@link #getVariablesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.VariableValuePb>
  getVariables();
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 1;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.VariableValuePb>
  getVariablesMap();
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 1;</code>
   */
  /* nullable */
io.littlehorse.jlib.common.proto.VariableValuePb getVariablesOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.jlib.common.proto.VariableValuePb defaultValue);
  /**
   * <code>map&lt;string, .littlehorse.VariableValuePb&gt; variables = 1;</code>
   */
  io.littlehorse.jlib.common.proto.VariableValuePb getVariablesOrThrow(
      java.lang.String key);

  /**
   * <code>int32 thread_run_number = 2;</code>
   * @return The threadRunNumber.
   */
  int getThreadRunNumber();

  /**
   * <code>string thread_spec_name = 3;</code>
   * @return The threadSpecName.
   */
  java.lang.String getThreadSpecName();
  /**
   * <code>string thread_spec_name = 3;</code>
   * @return The bytes for threadSpecName.
   */
  com.google.protobuf.ByteString
      getThreadSpecNameBytes();

  /**
   * <code>optional int32 parent_thread = 4;</code>
   * @return Whether the parentThread field is set.
   */
  boolean hasParentThread();
  /**
   * <code>optional int32 parent_thread = 4;</code>
   * @return The parentThread.
   */
  int getParentThread();

  /**
   * <code>.littlehorse.ThreadTypePb type = 5;</code>
   * @return The enum numeric value on the wire for type.
   */
  int getTypeValue();
  /**
   * <code>.littlehorse.ThreadTypePb type = 5;</code>
   * @return The type.
   */
  io.littlehorse.jlib.common.proto.ThreadTypePb getType();
}