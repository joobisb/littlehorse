// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_run.proto

package io.littlehorse.common.proto;

public interface NodeRunPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.NodeRunPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string wf_run_id = 1;</code>
   * @return The wfRunId.
   */
  java.lang.String getWfRunId();
  /**
   * <code>string wf_run_id = 1;</code>
   * @return The bytes for wfRunId.
   */
  com.google.protobuf.ByteString
      getWfRunIdBytes();

  /**
   * <code>int32 thread_run_number = 2;</code>
   * @return The threadRunNumber.
   */
  int getThreadRunNumber();

  /**
   * <code>int32 position = 3;</code>
   * @return The position.
   */
  int getPosition();

  /**
   * <code>int32 attempt_number = 4;</code>
   * @return The attemptNumber.
   */
  int getAttemptNumber();

  /**
   * <code>int32 number = 5;</code>
   * @return The number.
   */
  int getNumber();

  /**
   * <code>.lh_proto.LHStatusPb status = 6;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.lh_proto.LHStatusPb status = 6;</code>
   * @return The status.
   */
  io.littlehorse.common.proto.LHStatusPb getStatus();

  /**
   * <code>.google.protobuf.Timestamp arrival_time = 7;</code>
   * @return Whether the arrivalTime field is set.
   */
  boolean hasArrivalTime();
  /**
   * <code>.google.protobuf.Timestamp arrival_time = 7;</code>
   * @return The arrivalTime.
   */
  com.google.protobuf.Timestamp getArrivalTime();
  /**
   * <code>.google.protobuf.Timestamp arrival_time = 7;</code>
   */
  com.google.protobuf.TimestampOrBuilder getArrivalTimeOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp end_time = 8;</code>
   * @return Whether the endTime field is set.
   */
  boolean hasEndTime();
  /**
   * <code>.google.protobuf.Timestamp end_time = 8;</code>
   * @return The endTime.
   */
  com.google.protobuf.Timestamp getEndTime();
  /**
   * <code>.google.protobuf.Timestamp end_time = 8;</code>
   */
  com.google.protobuf.TimestampOrBuilder getEndTimeOrBuilder();

  /**
   * <code>string wf_spec_id = 9;</code>
   * @return The wfSpecId.
   */
  java.lang.String getWfSpecId();
  /**
   * <code>string wf_spec_id = 9;</code>
   * @return The bytes for wfSpecId.
   */
  com.google.protobuf.ByteString
      getWfSpecIdBytes();

  /**
   * <code>string thread_spec_name = 10;</code>
   * @return The threadSpecName.
   */
  java.lang.String getThreadSpecName();
  /**
   * <code>string thread_spec_name = 10;</code>
   * @return The bytes for threadSpecName.
   */
  com.google.protobuf.ByteString
      getThreadSpecNameBytes();

  /**
   * <code>string node_name = 11;</code>
   * @return The nodeName.
   */
  java.lang.String getNodeName();
  /**
   * <code>string node_name = 11;</code>
   * @return The bytes for nodeName.
   */
  com.google.protobuf.ByteString
      getNodeNameBytes();

  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 12;</code>
   * @return Whether the resultCode field is set.
   */
  boolean hasResultCode();
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 12;</code>
   * @return The enum numeric value on the wire for resultCode.
   */
  int getResultCodeValue();
  /**
   * <code>.lh_proto.TaskResultCodePb result_code = 12;</code>
   * @return The resultCode.
   */
  io.littlehorse.common.proto.TaskResultCodePb getResultCode();

  /**
   * <code>string error_message = 13;</code>
   * @return Whether the errorMessage field is set.
   */
  boolean hasErrorMessage();
  /**
   * <code>string error_message = 13;</code>
   * @return The errorMessage.
   */
  java.lang.String getErrorMessage();
  /**
   * <code>string error_message = 13;</code>
   * @return The bytes for errorMessage.
   */
  com.google.protobuf.ByteString
      getErrorMessageBytes();

  /**
   * <code>repeated .lh_proto.FailurePb failures = 14;</code>
   */
  java.util.List<io.littlehorse.common.proto.FailurePb> 
      getFailuresList();
  /**
   * <code>repeated .lh_proto.FailurePb failures = 14;</code>
   */
  io.littlehorse.common.proto.FailurePb getFailures(int index);
  /**
   * <code>repeated .lh_proto.FailurePb failures = 14;</code>
   */
  int getFailuresCount();
  /**
   * <code>repeated .lh_proto.FailurePb failures = 14;</code>
   */
  java.util.List<? extends io.littlehorse.common.proto.FailurePbOrBuilder> 
      getFailuresOrBuilderList();
  /**
   * <code>repeated .lh_proto.FailurePb failures = 14;</code>
   */
  io.littlehorse.common.proto.FailurePbOrBuilder getFailuresOrBuilder(
      int index);

  /**
   * <code>.lh_proto.TaskRunPb task = 15;</code>
   * @return Whether the task field is set.
   */
  boolean hasTask();
  /**
   * <code>.lh_proto.TaskRunPb task = 15;</code>
   * @return The task.
   */
  io.littlehorse.common.proto.TaskRunPb getTask();
  /**
   * <code>.lh_proto.TaskRunPb task = 15;</code>
   */
  io.littlehorse.common.proto.TaskRunPbOrBuilder getTaskOrBuilder();

  /**
   * <code>.lh_proto.ExternalEventRunPb external_event = 16;</code>
   * @return Whether the externalEvent field is set.
   */
  boolean hasExternalEvent();
  /**
   * <code>.lh_proto.ExternalEventRunPb external_event = 16;</code>
   * @return The externalEvent.
   */
  io.littlehorse.common.proto.ExternalEventRunPb getExternalEvent();
  /**
   * <code>.lh_proto.ExternalEventRunPb external_event = 16;</code>
   */
  io.littlehorse.common.proto.ExternalEventRunPbOrBuilder getExternalEventOrBuilder();

  /**
   * <code>.lh_proto.EntrypointRunPb entrypoint = 17;</code>
   * @return Whether the entrypoint field is set.
   */
  boolean hasEntrypoint();
  /**
   * <code>.lh_proto.EntrypointRunPb entrypoint = 17;</code>
   * @return The entrypoint.
   */
  io.littlehorse.common.proto.EntrypointRunPb getEntrypoint();
  /**
   * <code>.lh_proto.EntrypointRunPb entrypoint = 17;</code>
   */
  io.littlehorse.common.proto.EntrypointRunPbOrBuilder getEntrypointOrBuilder();

  /**
   * <code>.lh_proto.ExitRunPb exit = 19;</code>
   * @return Whether the exit field is set.
   */
  boolean hasExit();
  /**
   * <code>.lh_proto.ExitRunPb exit = 19;</code>
   * @return The exit.
   */
  io.littlehorse.common.proto.ExitRunPb getExit();
  /**
   * <code>.lh_proto.ExitRunPb exit = 19;</code>
   */
  io.littlehorse.common.proto.ExitRunPbOrBuilder getExitOrBuilder();

  /**
   * <code>.lh_proto.StartThreadRunPb start_thread = 20;</code>
   * @return Whether the startThread field is set.
   */
  boolean hasStartThread();
  /**
   * <code>.lh_proto.StartThreadRunPb start_thread = 20;</code>
   * @return The startThread.
   */
  io.littlehorse.common.proto.StartThreadRunPb getStartThread();
  /**
   * <code>.lh_proto.StartThreadRunPb start_thread = 20;</code>
   */
  io.littlehorse.common.proto.StartThreadRunPbOrBuilder getStartThreadOrBuilder();

  /**
   * <code>.lh_proto.WaitThreadRunPb wait_thread = 21;</code>
   * @return Whether the waitThread field is set.
   */
  boolean hasWaitThread();
  /**
   * <code>.lh_proto.WaitThreadRunPb wait_thread = 21;</code>
   * @return The waitThread.
   */
  io.littlehorse.common.proto.WaitThreadRunPb getWaitThread();
  /**
   * <code>.lh_proto.WaitThreadRunPb wait_thread = 21;</code>
   */
  io.littlehorse.common.proto.WaitThreadRunPbOrBuilder getWaitThreadOrBuilder();

  /**
   * <code>.lh_proto.SleepNodeRunPb sleep = 22;</code>
   * @return Whether the sleep field is set.
   */
  boolean hasSleep();
  /**
   * <code>.lh_proto.SleepNodeRunPb sleep = 22;</code>
   * @return The sleep.
   */
  io.littlehorse.common.proto.SleepNodeRunPb getSleep();
  /**
   * <code>.lh_proto.SleepNodeRunPb sleep = 22;</code>
   */
  io.littlehorse.common.proto.SleepNodeRunPbOrBuilder getSleepOrBuilder();

  /**
   * <code>repeated int32 failure_handler_ids = 23;</code>
   * @return A list containing the failureHandlerIds.
   */
  java.util.List<java.lang.Integer> getFailureHandlerIdsList();
  /**
   * <code>repeated int32 failure_handler_ids = 23;</code>
   * @return The count of failureHandlerIds.
   */
  int getFailureHandlerIdsCount();
  /**
   * <code>repeated int32 failure_handler_ids = 23;</code>
   * @param index The index of the element to return.
   * @return The failureHandlerIds at the given index.
   */
  int getFailureHandlerIds(int index);

  public io.littlehorse.common.proto.NodeRunPb.NodeTypeCase getNodeTypeCase();
}
