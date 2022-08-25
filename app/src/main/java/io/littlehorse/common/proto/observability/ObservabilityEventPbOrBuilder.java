// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: observability.proto

package io.littlehorse.common.proto.observability;

public interface ObservabilityEventPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.ObservabilityEventPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Timestamp time = 1;</code>
   * @return Whether the time field is set.
   */
  boolean hasTime();
  /**
   * <code>.google.protobuf.Timestamp time = 1;</code>
   * @return The time.
   */
  com.google.protobuf.Timestamp getTime();
  /**
   * <code>.google.protobuf.Timestamp time = 1;</code>
   */
  com.google.protobuf.TimestampOrBuilder getTimeOrBuilder();

  /**
   * <code>.lh_proto.WfRunStatusChangeOePb wf_run_status = 2;</code>
   * @return Whether the wfRunStatus field is set.
   */
  boolean hasWfRunStatus();
  /**
   * <code>.lh_proto.WfRunStatusChangeOePb wf_run_status = 2;</code>
   * @return The wfRunStatus.
   */
  io.littlehorse.common.proto.observability.WfRunStatusChangeOePb getWfRunStatus();
  /**
   * <code>.lh_proto.WfRunStatusChangeOePb wf_run_status = 2;</code>
   */
  io.littlehorse.common.proto.observability.WfRunStatusChangeOePbOrBuilder getWfRunStatusOrBuilder();

  /**
   * <code>.lh_proto.RunStartOePb run_start = 3;</code>
   * @return Whether the runStart field is set.
   */
  boolean hasRunStart();
  /**
   * <code>.lh_proto.RunStartOePb run_start = 3;</code>
   * @return The runStart.
   */
  io.littlehorse.common.proto.observability.RunStartOePb getRunStart();
  /**
   * <code>.lh_proto.RunStartOePb run_start = 3;</code>
   */
  io.littlehorse.common.proto.observability.RunStartOePbOrBuilder getRunStartOrBuilder();

  /**
   * <code>.lh_proto.ThreadStartOePb thread_start = 4;</code>
   * @return Whether the threadStart field is set.
   */
  boolean hasThreadStart();
  /**
   * <code>.lh_proto.ThreadStartOePb thread_start = 4;</code>
   * @return The threadStart.
   */
  io.littlehorse.common.proto.observability.ThreadStartOePb getThreadStart();
  /**
   * <code>.lh_proto.ThreadStartOePb thread_start = 4;</code>
   */
  io.littlehorse.common.proto.observability.ThreadStartOePbOrBuilder getThreadStartOrBuilder();

  /**
   * <code>.lh_proto.TaskScheduledOePb task_schedule = 5;</code>
   * @return Whether the taskSchedule field is set.
   */
  boolean hasTaskSchedule();
  /**
   * <code>.lh_proto.TaskScheduledOePb task_schedule = 5;</code>
   * @return The taskSchedule.
   */
  io.littlehorse.common.proto.observability.TaskScheduledOePb getTaskSchedule();
  /**
   * <code>.lh_proto.TaskScheduledOePb task_schedule = 5;</code>
   */
  io.littlehorse.common.proto.observability.TaskScheduledOePbOrBuilder getTaskScheduleOrBuilder();

  /**
   * <code>.lh_proto.TaskStartOePb task_start = 6;</code>
   * @return Whether the taskStart field is set.
   */
  boolean hasTaskStart();
  /**
   * <code>.lh_proto.TaskStartOePb task_start = 6;</code>
   * @return The taskStart.
   */
  io.littlehorse.common.proto.observability.TaskStartOePb getTaskStart();
  /**
   * <code>.lh_proto.TaskStartOePb task_start = 6;</code>
   */
  io.littlehorse.common.proto.observability.TaskStartOePbOrBuilder getTaskStartOrBuilder();

  /**
   * <code>.lh_proto.TaskResultOePb task_result = 7;</code>
   * @return Whether the taskResult field is set.
   */
  boolean hasTaskResult();
  /**
   * <code>.lh_proto.TaskResultOePb task_result = 7;</code>
   * @return The taskResult.
   */
  io.littlehorse.common.proto.observability.TaskResultOePb getTaskResult();
  /**
   * <code>.lh_proto.TaskResultOePb task_result = 7;</code>
   */
  io.littlehorse.common.proto.observability.TaskResultOePbOrBuilder getTaskResultOrBuilder();

  /**
   * <code>.lh_proto.ThreadStatusChangeOePb thread_status = 8;</code>
   * @return Whether the threadStatus field is set.
   */
  boolean hasThreadStatus();
  /**
   * <code>.lh_proto.ThreadStatusChangeOePb thread_status = 8;</code>
   * @return The threadStatus.
   */
  io.littlehorse.common.proto.observability.ThreadStatusChangeOePb getThreadStatus();
  /**
   * <code>.lh_proto.ThreadStatusChangeOePb thread_status = 8;</code>
   */
  io.littlehorse.common.proto.observability.ThreadStatusChangeOePbOrBuilder getThreadStatusOrBuilder();

  public io.littlehorse.common.proto.observability.ObservabilityEventPb.EventCase getEventCase();
}