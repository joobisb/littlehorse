// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: command.proto

package io.littlehorse.common.proto;

public interface PutWfSpecPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.PutWfSpecPb)
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
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 5;</code>
   */
  int getThreadSpecsCount();
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 5;</code>
   */
  boolean containsThreadSpecs(
      java.lang.String key);
  /**
   * Use {@link #getThreadSpecsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.common.proto.ThreadSpecPb>
  getThreadSpecs();
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 5;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.common.proto.ThreadSpecPb>
  getThreadSpecsMap();
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 5;</code>
   */

  io.littlehorse.common.proto.ThreadSpecPb getThreadSpecsOrDefault(
      java.lang.String key,
      io.littlehorse.common.proto.ThreadSpecPb defaultValue);
  /**
   * <code>map&lt;string, .lh_proto.ThreadSpecPb&gt; thread_specs = 5;</code>
   */

  io.littlehorse.common.proto.ThreadSpecPb getThreadSpecsOrThrow(
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
}