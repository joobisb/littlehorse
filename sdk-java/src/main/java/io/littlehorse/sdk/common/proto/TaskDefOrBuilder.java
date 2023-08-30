// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task_def.proto

package io.littlehorse.sdk.common.proto;

public interface TaskDefOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskDef)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>repeated .littlehorse.VariableDef input_vars = 2;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.VariableDef> 
      getInputVarsList();
  /**
   * <code>repeated .littlehorse.VariableDef input_vars = 2;</code>
   */
  io.littlehorse.sdk.common.proto.VariableDef getInputVars(int index);
  /**
   * <code>repeated .littlehorse.VariableDef input_vars = 2;</code>
   */
  int getInputVarsCount();
  /**
   * <code>repeated .littlehorse.VariableDef input_vars = 2;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.VariableDefOrBuilder> 
      getInputVarsOrBuilderList();
  /**
   * <code>repeated .littlehorse.VariableDef input_vars = 2;</code>
   */
  io.littlehorse.sdk.common.proto.VariableDefOrBuilder getInputVarsOrBuilder(
      int index);

  /**
   * <code>.google.protobuf.Timestamp created_at = 3;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 3;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 3;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();
}