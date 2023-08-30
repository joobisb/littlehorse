// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_spec.proto

package io.littlehorse.sdk.common.proto;

public interface WfSpecOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.WfSpec)
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
   * <code>int32 version = 2;</code>
   * @return The version.
   */
  int getVersion();

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

  /**
   * <code>.littlehorse.LHStatus status = 4;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <code>.littlehorse.LHStatus status = 4;</code>
   * @return The status.
   */
  io.littlehorse.sdk.common.proto.LHStatus getStatus();

  /**
   * <code>map&lt;string, .littlehorse.ThreadSpec&gt; thread_specs = 5;</code>
   */
  int getThreadSpecsCount();
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpec&gt; thread_specs = 5;</code>
   */
  boolean containsThreadSpecs(
      java.lang.String key);
  /**
   * Use {@link #getThreadSpecsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpec>
  getThreadSpecs();
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpec&gt; thread_specs = 5;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpec>
  getThreadSpecsMap();
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpec&gt; thread_specs = 5;</code>
   */
  /* nullable */
io.littlehorse.sdk.common.proto.ThreadSpec getThreadSpecsOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.sdk.common.proto.ThreadSpec defaultValue);
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpec&gt; thread_specs = 5;</code>
   */
  io.littlehorse.sdk.common.proto.ThreadSpec getThreadSpecsOrThrow(
      java.lang.String key);

  /**
   * <code>string entrypoint_thread_name = 6;</code>
   * @return The entrypointThreadName.
   */
  java.lang.String getEntrypointThreadName();
  /**
   * <code>string entrypoint_thread_name = 6;</code>
   * @return The bytes for entrypointThreadName.
   */
  com.google.protobuf.ByteString
      getEntrypointThreadNameBytes();

  /**
   * <code>int32 retention_hours = 7;</code>
   * @return The retentionHours.
   */
  int getRetentionHours();
}