// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

public interface TaskScheduledOePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskScheduledOePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string task_def_name = 1;</code>
   * @return The taskDefName.
   */
  java.lang.String getTaskDefName();
  /**
   * <code>string task_def_name = 1;</code>
   * @return The bytes for taskDefName.
   */
  com.google.protobuf.ByteString
      getTaskDefNameBytes();

  /**
   * <code>int32 thread_run_number = 2;</code>
   * @return The threadRunNumber.
   */
  int getThreadRunNumber();

  /**
   * <code>int32 task_run_number = 3;</code>
   * @return The taskRunNumber.
   */
  int getTaskRunNumber();

  /**
   * <code>int32 task_run_position = 4;</code>
   * @return The taskRunPosition.
   */
  int getTaskRunPosition();

  /**
   * <code>repeated .littlehorse.VarNameAndValPb variables = 5;</code>
   */
  java.util.List<io.littlehorse.jlib.common.proto.VarNameAndValPb> 
      getVariablesList();
  /**
   * <code>repeated .littlehorse.VarNameAndValPb variables = 5;</code>
   */
  io.littlehorse.jlib.common.proto.VarNameAndValPb getVariables(int index);
  /**
   * <code>repeated .littlehorse.VarNameAndValPb variables = 5;</code>
   */
  int getVariablesCount();
  /**
   * <code>repeated .littlehorse.VarNameAndValPb variables = 5;</code>
   */
  java.util.List<? extends io.littlehorse.jlib.common.proto.VarNameAndValPbOrBuilder> 
      getVariablesOrBuilderList();
  /**
   * <code>repeated .littlehorse.VarNameAndValPb variables = 5;</code>
   */
  io.littlehorse.jlib.common.proto.VarNameAndValPbOrBuilder getVariablesOrBuilder(
      int index);

  /**
   * <code>string node_name = 6;</code>
   * @return The nodeName.
   */
  java.lang.String getNodeName();
  /**
   * <code>string node_name = 6;</code>
   * @return The bytes for nodeName.
   */
  com.google.protobuf.ByteString
      getNodeNameBytes();

  /**
   * <code>string wf_spec_name = 7;</code>
   * @return The wfSpecName.
   */
  java.lang.String getWfSpecName();
  /**
   * <code>string wf_spec_name = 7;</code>
   * @return The bytes for wfSpecName.
   */
  com.google.protobuf.ByteString
      getWfSpecNameBytes();

  /**
   * <code>int32 wf_spec_version = 8;</code>
   * @return The wfSpecVersion.
   */
  int getWfSpecVersion();

  /**
   * <code>int32 attempt_number = 9;</code>
   * @return The attemptNumber.
   */
  int getAttemptNumber();
}