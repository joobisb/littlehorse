// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface TopologyInstanceStateReplyPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:littlehorse.TopologyInstanceStateReplyPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .littlehorse.ServerStatePb servers_core = 1;</code>
   */
  java.util.List<io.littlehorse.common.proto.ServerStatePb> 
      getServersCoreList();
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_core = 1;</code>
   */
  io.littlehorse.common.proto.ServerStatePb getServersCore(int index);
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_core = 1;</code>
   */
  int getServersCoreCount();
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_core = 1;</code>
   */
  java.util.List<? extends io.littlehorse.common.proto.ServerStatePbOrBuilder> 
      getServersCoreOrBuilderList();
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_core = 1;</code>
   */
  io.littlehorse.common.proto.ServerStatePbOrBuilder getServersCoreOrBuilder(
      int index);

  /**
   * <code>repeated .littlehorse.ServerStatePb servers_timer = 2;</code>
   */
  java.util.List<io.littlehorse.common.proto.ServerStatePb> 
      getServersTimerList();
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_timer = 2;</code>
   */
  io.littlehorse.common.proto.ServerStatePb getServersTimer(int index);
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_timer = 2;</code>
   */
  int getServersTimerCount();
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_timer = 2;</code>
   */
  java.util.List<? extends io.littlehorse.common.proto.ServerStatePbOrBuilder> 
      getServersTimerOrBuilderList();
  /**
   * <code>repeated .littlehorse.ServerStatePb servers_timer = 2;</code>
   */
  io.littlehorse.common.proto.ServerStatePbOrBuilder getServersTimerOrBuilder(
      int index);
}
