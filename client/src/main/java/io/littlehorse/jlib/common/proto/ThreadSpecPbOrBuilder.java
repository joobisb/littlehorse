// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service.proto

package io.littlehorse.jlib.common.proto;

public interface ThreadSpecPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.ThreadSpecPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>map&lt;string, .littlehorse.NodePb&gt; nodes = 1;</code>
   */
  int getNodesCount();
  /**
   * <code>map&lt;string, .littlehorse.NodePb&gt; nodes = 1;</code>
   */
  boolean containsNodes(
      java.lang.String key);
  /**
   * Use {@link #getNodesMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.NodePb>
  getNodes();
  /**
   * <code>map&lt;string, .littlehorse.NodePb&gt; nodes = 1;</code>
   */
  java.util.Map<java.lang.String, io.littlehorse.jlib.common.proto.NodePb>
  getNodesMap();
  /**
   * <code>map&lt;string, .littlehorse.NodePb&gt; nodes = 1;</code>
   */
  /* nullable */
io.littlehorse.jlib.common.proto.NodePb getNodesOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.jlib.common.proto.NodePb defaultValue);
  /**
   * <code>map&lt;string, .littlehorse.NodePb&gt; nodes = 1;</code>
   */
  io.littlehorse.jlib.common.proto.NodePb getNodesOrThrow(
      java.lang.String key);

  /**
   * <code>repeated .littlehorse.VariableDefPb variable_defs = 2;</code>
   */
  java.util.List<io.littlehorse.jlib.common.proto.VariableDefPb> 
      getVariableDefsList();
  /**
   * <code>repeated .littlehorse.VariableDefPb variable_defs = 2;</code>
   */
  io.littlehorse.jlib.common.proto.VariableDefPb getVariableDefs(int index);
  /**
   * <code>repeated .littlehorse.VariableDefPb variable_defs = 2;</code>
   */
  int getVariableDefsCount();
  /**
   * <code>repeated .littlehorse.VariableDefPb variable_defs = 2;</code>
   */
  java.util.List<? extends io.littlehorse.jlib.common.proto.VariableDefPbOrBuilder> 
      getVariableDefsOrBuilderList();
  /**
   * <code>repeated .littlehorse.VariableDefPb variable_defs = 2;</code>
   */
  io.littlehorse.jlib.common.proto.VariableDefPbOrBuilder getVariableDefsOrBuilder(
      int index);

  /**
   * <code>repeated .littlehorse.InterruptDefPb interrupt_defs = 3;</code>
   */
  java.util.List<io.littlehorse.jlib.common.proto.InterruptDefPb> 
      getInterruptDefsList();
  /**
   * <code>repeated .littlehorse.InterruptDefPb interrupt_defs = 3;</code>
   */
  io.littlehorse.jlib.common.proto.InterruptDefPb getInterruptDefs(int index);
  /**
   * <code>repeated .littlehorse.InterruptDefPb interrupt_defs = 3;</code>
   */
  int getInterruptDefsCount();
  /**
   * <code>repeated .littlehorse.InterruptDefPb interrupt_defs = 3;</code>
   */
  java.util.List<? extends io.littlehorse.jlib.common.proto.InterruptDefPbOrBuilder> 
      getInterruptDefsOrBuilderList();
  /**
   * <code>repeated .littlehorse.InterruptDefPb interrupt_defs = 3;</code>
   */
  io.littlehorse.jlib.common.proto.InterruptDefPbOrBuilder getInterruptDefsOrBuilder(
      int index);
}