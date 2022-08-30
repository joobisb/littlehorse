// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package io.littlehorse.common.proto.server;

public interface RemoteStoreQueryRequestPbOrBuilder extends
    // @@protoc_insertion_point(interface_extends:lh_proto.RemoteStoreQueryRequestPb)
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
   * <code>int32 partition = 2;</code>
   * @return The partition.
   */
  int getPartition();

  /**
   * <code>string store_key = 3;</code>
   * @return The storeKey.
   */
  java.lang.String getStoreKey();
  /**
   * <code>string store_key = 3;</code>
   * @return The bytes for storeKey.
   */
  com.google.protobuf.ByteString
      getStoreKeyBytes();

  /**
   * <code>bool is_active_store = 4;</code>
   * @return The isActiveStore.
   */
  boolean getIsActiveStore();
}
