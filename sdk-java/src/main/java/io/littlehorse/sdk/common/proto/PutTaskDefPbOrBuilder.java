// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.sdk.common.proto;

public interface PutTaskDefPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.PutTaskDefPb)
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
   * <code>repeated .littlehorse.VariableDefPb input_vars = 2;</code>
   */
  java.util.List<io.littlehorse.sdk.common.proto.VariableDefPb> 
      getInputVarsList();
  /**
   * <code>repeated .littlehorse.VariableDefPb input_vars = 2;</code>
   */
  io.littlehorse.sdk.common.proto.VariableDefPb getInputVars(int index);
  /**
   * <code>repeated .littlehorse.VariableDefPb input_vars = 2;</code>
   */
  int getInputVarsCount();
  /**
   * <code>repeated .littlehorse.VariableDefPb input_vars = 2;</code>
   */
  java.util.List<? extends io.littlehorse.sdk.common.proto.VariableDefPbOrBuilder> 
      getInputVarsOrBuilderList();
  /**
   * <code>repeated .littlehorse.VariableDefPb input_vars = 2;</code>
   */
  io.littlehorse.sdk.common.proto.VariableDefPbOrBuilder getInputVarsOrBuilder(
      int index);
}