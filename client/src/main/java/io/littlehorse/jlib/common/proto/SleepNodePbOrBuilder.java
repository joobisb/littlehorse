// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

public interface SleepNodePbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.SleepNodePb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.littlehorse.VariableAssignmentPb raw_seconds = 1;</code>
   * @return Whether the rawSeconds field is set.
   */
  boolean hasRawSeconds();
  /**
   * <code>.littlehorse.VariableAssignmentPb raw_seconds = 1;</code>
   * @return The rawSeconds.
   */
  io.littlehorse.jlib.common.proto.VariableAssignmentPb getRawSeconds();
  /**
   * <code>.littlehorse.VariableAssignmentPb raw_seconds = 1;</code>
   */
  io.littlehorse.jlib.common.proto.VariableAssignmentPbOrBuilder getRawSecondsOrBuilder();

  /**
   * <code>.littlehorse.VariableAssignmentPb timestamp = 2;</code>
   * @return Whether the timestamp field is set.
   */
  boolean hasTimestamp();
  /**
   * <code>.littlehorse.VariableAssignmentPb timestamp = 2;</code>
   * @return The timestamp.
   */
  io.littlehorse.jlib.common.proto.VariableAssignmentPb getTimestamp();
  /**
   * <code>.littlehorse.VariableAssignmentPb timestamp = 2;</code>
   */
  io.littlehorse.jlib.common.proto.VariableAssignmentPbOrBuilder getTimestampOrBuilder();

  /**
   * <code>.littlehorse.VariableAssignmentPb iso_date = 3;</code>
   * @return Whether the isoDate field is set.
   */
  boolean hasIsoDate();
  /**
   * <code>.littlehorse.VariableAssignmentPb iso_date = 3;</code>
   * @return The isoDate.
   */
  io.littlehorse.jlib.common.proto.VariableAssignmentPb getIsoDate();
  /**
   * <code>.littlehorse.VariableAssignmentPb iso_date = 3;</code>
   */
  io.littlehorse.jlib.common.proto.VariableAssignmentPbOrBuilder getIsoDateOrBuilder();

  public io.littlehorse.jlib.common.proto.SleepNodePb.SleepLengthCase getSleepLengthCase();
}