// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scheduler.proto

package io.littlehorse.common.proto.scheduler;

public interface SchedulerTimerPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.SchedulerTimerPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.google.protobuf.Timestamp maturation_time = 1;</code>
   * @return Whether the maturationTime field is set.
   */
  boolean hasMaturationTime();
  /**
   * <code>.google.protobuf.Timestamp maturation_time = 1;</code>
   * @return The maturationTime.
   */
  com.google.protobuf.Timestamp getMaturationTime();
  /**
   * <code>.google.protobuf.Timestamp maturation_time = 1;</code>
   */
  com.google.protobuf.TimestampOrBuilder getMaturationTimeOrBuilder();

  /**
   * <code>string wf_run_id = 2;</code>
   * @return The wfRunId.
   */
  java.lang.String getWfRunId();
  /**
   * <code>string wf_run_id = 2;</code>
   * @return The bytes for wfRunId.
   */
  com.google.protobuf.ByteString
      getWfRunIdBytes();

  /**
   * <code>.lh_proto.WfRunEventPb event = 3;</code>
   * @return Whether the event field is set.
   */
  boolean hasEvent();
  /**
   * <code>.lh_proto.WfRunEventPb event = 3;</code>
   * @return The event.
   */
  io.littlehorse.common.proto.scheduler.WfRunEventPb getEvent();
  /**
   * <code>.lh_proto.WfRunEventPb event = 3;</code>
   */
  io.littlehorse.common.proto.scheduler.WfRunEventPbOrBuilder getEventOrBuilder();
}