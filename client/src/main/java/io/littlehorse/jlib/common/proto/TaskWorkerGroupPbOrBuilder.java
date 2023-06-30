// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

public interface TaskWorkerGroupPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TaskWorkerGroupPb)
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
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return Whether the createdAt field is set.
   */
  boolean hasCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   * @return The createdAt.
   */
  com.google.protobuf.Timestamp getCreatedAt();
  /**
   * <code>.google.protobuf.Timestamp created_at = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder();

  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  int getTaskWorkersCount();
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  boolean containsTaskWorkers(
      java.lang.String key);
  /**
   * Use {@link #getTaskWorkersMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
  getTaskWorkers();
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb>
  getTaskWorkersMap();
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  /* nullable */
io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb getTaskWorkersOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb defaultValue);
  /**
   * <code>map&lt;string, .littlehorse.TaskWorkerMetadataPb&gt; task_workers = 3;</code>
   */
  io.littlehorse.jlib.common.proto.TaskWorkerMetadataPb getTaskWorkersOrThrow(
      java.lang.String key);
}