// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: internal_server.proto

package io.littlehorse.common.proto;

public interface CentralStoreQueryPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.CentralStoreQueryPb)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string store_name = 1;</code>
   * @return The storeName.
   */
  java.lang.String getStoreName();
  /**
   * <code>string store_name = 1;</code>
   * @return The bytes for storeName.
   */
  com.google.protobuf.ByteString
      getStoreNameBytes();

  /**
   * <code>string key = 2;</code>
   * @return The key.
   */
  java.lang.String getKey();
  /**
   * <code>string key = 2;</code>
   * @return The bytes for key.
   */
  com.google.protobuf.ByteString
      getKeyBytes();

  /**
   * <code>int32 specific_partition = 3;</code>
   * @return Whether the specificPartition field is set.
   */
  boolean hasSpecificPartition();
  /**
   * <code>int32 specific_partition = 3;</code>
   * @return The specificPartition.
   */
  int getSpecificPartition();

  /**
   * <code>bool enable_stale_stores = 4;</code>
   * @return The enableStaleStores.
   */
  boolean getEnableStaleStores();
}
