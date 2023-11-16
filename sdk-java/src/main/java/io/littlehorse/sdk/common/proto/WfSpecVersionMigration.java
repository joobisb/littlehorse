// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wf_spec.proto

package io.littlehorse.sdk.common.proto;

/**
 * Protobuf type {@code littlehorse.WfSpecVersionMigration}
 */
public final class WfSpecVersionMigration extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:littlehorse.WfSpecVersionMigration)
    WfSpecVersionMigrationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use WfSpecVersionMigration.newBuilder() to construct.
  private WfSpecVersionMigration(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private WfSpecVersionMigration() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new WfSpecVersionMigration();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.littlehorse.sdk.common.proto.WfSpecOuterClass.internal_static_littlehorse_WfSpecVersionMigration_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 2:
        return internalGetThreadSpecMigrations();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.littlehorse.sdk.common.proto.WfSpecOuterClass.internal_static_littlehorse_WfSpecVersionMigration_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.littlehorse.sdk.common.proto.WfSpecVersionMigration.class, io.littlehorse.sdk.common.proto.WfSpecVersionMigration.Builder.class);
  }

  public static final int NEW_WF_SPEC_VERSION_FIELD_NUMBER = 1;
  private int newWfSpecVersion_ = 0;
  /**
   * <code>int32 new_wf_spec_version = 1;</code>
   * @return The newWfSpecVersion.
   */
  @java.lang.Override
  public int getNewWfSpecVersion() {
    return newWfSpecVersion_;
  }

  public static final int THREAD_SPEC_MIGRATIONS_FIELD_NUMBER = 2;
  private static final class ThreadSpecMigrationsDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>newDefaultInstance(
                io.littlehorse.sdk.common.proto.WfSpecOuterClass.internal_static_littlehorse_WfSpecVersionMigration_ThreadSpecMigrationsEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.STRING,
                "",
                com.google.protobuf.WireFormat.FieldType.MESSAGE,
                io.littlehorse.sdk.common.proto.ThreadSpecMigration.getDefaultInstance());
  }
  @SuppressWarnings("serial")
  private com.google.protobuf.MapField<
      java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> threadSpecMigrations_;
  private com.google.protobuf.MapField<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>
  internalGetThreadSpecMigrations() {
    if (threadSpecMigrations_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          ThreadSpecMigrationsDefaultEntryHolder.defaultEntry);
    }
    return threadSpecMigrations_;
  }
  public int getThreadSpecMigrationsCount() {
    return internalGetThreadSpecMigrations().getMap().size();
  }
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
   */
  @java.lang.Override
  public boolean containsThreadSpecMigrations(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    return internalGetThreadSpecMigrations().getMap().containsKey(key);
  }
  /**
   * Use {@link #getThreadSpecMigrationsMap()} instead.
   */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> getThreadSpecMigrations() {
    return getThreadSpecMigrationsMap();
  }
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
   */
  @java.lang.Override
  public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> getThreadSpecMigrationsMap() {
    return internalGetThreadSpecMigrations().getMap();
  }
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
   */
  @java.lang.Override
  public /* nullable */
io.littlehorse.sdk.common.proto.ThreadSpecMigration getThreadSpecMigrationsOrDefault(
      java.lang.String key,
      /* nullable */
io.littlehorse.sdk.common.proto.ThreadSpecMigration defaultValue) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> map =
        internalGetThreadSpecMigrations().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
   */
  @java.lang.Override
  public io.littlehorse.sdk.common.proto.ThreadSpecMigration getThreadSpecMigrationsOrThrow(
      java.lang.String key) {
    if (key == null) { throw new NullPointerException("map key"); }
    java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> map =
        internalGetThreadSpecMigrations().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (newWfSpecVersion_ != 0) {
      output.writeInt32(1, newWfSpecVersion_);
    }
    com.google.protobuf.GeneratedMessageV3
      .serializeStringMapTo(
        output,
        internalGetThreadSpecMigrations(),
        ThreadSpecMigrationsDefaultEntryHolder.defaultEntry,
        2);
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (newWfSpecVersion_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, newWfSpecVersion_);
    }
    for (java.util.Map.Entry<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> entry
         : internalGetThreadSpecMigrations().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>
      threadSpecMigrations__ = ThreadSpecMigrationsDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, threadSpecMigrations__);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.littlehorse.sdk.common.proto.WfSpecVersionMigration)) {
      return super.equals(obj);
    }
    io.littlehorse.sdk.common.proto.WfSpecVersionMigration other = (io.littlehorse.sdk.common.proto.WfSpecVersionMigration) obj;

    if (getNewWfSpecVersion()
        != other.getNewWfSpecVersion()) return false;
    if (!internalGetThreadSpecMigrations().equals(
        other.internalGetThreadSpecMigrations())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + NEW_WF_SPEC_VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getNewWfSpecVersion();
    if (!internalGetThreadSpecMigrations().getMap().isEmpty()) {
      hash = (37 * hash) + THREAD_SPEC_MIGRATIONS_FIELD_NUMBER;
      hash = (53 * hash) + internalGetThreadSpecMigrations().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.littlehorse.sdk.common.proto.WfSpecVersionMigration prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code littlehorse.WfSpecVersionMigration}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:littlehorse.WfSpecVersionMigration)
      io.littlehorse.sdk.common.proto.WfSpecVersionMigrationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.littlehorse.sdk.common.proto.WfSpecOuterClass.internal_static_littlehorse_WfSpecVersionMigration_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetThreadSpecMigrations();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 2:
          return internalGetMutableThreadSpecMigrations();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.littlehorse.sdk.common.proto.WfSpecOuterClass.internal_static_littlehorse_WfSpecVersionMigration_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.littlehorse.sdk.common.proto.WfSpecVersionMigration.class, io.littlehorse.sdk.common.proto.WfSpecVersionMigration.Builder.class);
    }

    // Construct using io.littlehorse.sdk.common.proto.WfSpecVersionMigration.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      newWfSpecVersion_ = 0;
      internalGetMutableThreadSpecMigrations().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.littlehorse.sdk.common.proto.WfSpecOuterClass.internal_static_littlehorse_WfSpecVersionMigration_descriptor;
    }

    @java.lang.Override
    public io.littlehorse.sdk.common.proto.WfSpecVersionMigration getDefaultInstanceForType() {
      return io.littlehorse.sdk.common.proto.WfSpecVersionMigration.getDefaultInstance();
    }

    @java.lang.Override
    public io.littlehorse.sdk.common.proto.WfSpecVersionMigration build() {
      io.littlehorse.sdk.common.proto.WfSpecVersionMigration result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.littlehorse.sdk.common.proto.WfSpecVersionMigration buildPartial() {
      io.littlehorse.sdk.common.proto.WfSpecVersionMigration result = new io.littlehorse.sdk.common.proto.WfSpecVersionMigration(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(io.littlehorse.sdk.common.proto.WfSpecVersionMigration result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.newWfSpecVersion_ = newWfSpecVersion_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.threadSpecMigrations_ = internalGetThreadSpecMigrations();
        result.threadSpecMigrations_.makeImmutable();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.littlehorse.sdk.common.proto.WfSpecVersionMigration) {
        return mergeFrom((io.littlehorse.sdk.common.proto.WfSpecVersionMigration)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.littlehorse.sdk.common.proto.WfSpecVersionMigration other) {
      if (other == io.littlehorse.sdk.common.proto.WfSpecVersionMigration.getDefaultInstance()) return this;
      if (other.getNewWfSpecVersion() != 0) {
        setNewWfSpecVersion(other.getNewWfSpecVersion());
      }
      internalGetMutableThreadSpecMigrations().mergeFrom(
          other.internalGetThreadSpecMigrations());
      bitField0_ |= 0x00000002;
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              newWfSpecVersion_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              com.google.protobuf.MapEntry<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>
              threadSpecMigrations__ = input.readMessage(
                  ThreadSpecMigrationsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
              internalGetMutableThreadSpecMigrations().getMutableMap().put(
                  threadSpecMigrations__.getKey(), threadSpecMigrations__.getValue());
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int newWfSpecVersion_ ;
    /**
     * <code>int32 new_wf_spec_version = 1;</code>
     * @return The newWfSpecVersion.
     */
    @java.lang.Override
    public int getNewWfSpecVersion() {
      return newWfSpecVersion_;
    }
    /**
     * <code>int32 new_wf_spec_version = 1;</code>
     * @param value The newWfSpecVersion to set.
     * @return This builder for chaining.
     */
    public Builder setNewWfSpecVersion(int value) {

      newWfSpecVersion_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 new_wf_spec_version = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNewWfSpecVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      newWfSpecVersion_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> threadSpecMigrations_;
    private com.google.protobuf.MapField<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>
        internalGetThreadSpecMigrations() {
      if (threadSpecMigrations_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            ThreadSpecMigrationsDefaultEntryHolder.defaultEntry);
      }
      return threadSpecMigrations_;
    }
    private com.google.protobuf.MapField<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>
        internalGetMutableThreadSpecMigrations() {
      if (threadSpecMigrations_ == null) {
        threadSpecMigrations_ = com.google.protobuf.MapField.newMapField(
            ThreadSpecMigrationsDefaultEntryHolder.defaultEntry);
      }
      if (!threadSpecMigrations_.isMutable()) {
        threadSpecMigrations_ = threadSpecMigrations_.copy();
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return threadSpecMigrations_;
    }
    public int getThreadSpecMigrationsCount() {
      return internalGetThreadSpecMigrations().getMap().size();
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    @java.lang.Override
    public boolean containsThreadSpecMigrations(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      return internalGetThreadSpecMigrations().getMap().containsKey(key);
    }
    /**
     * Use {@link #getThreadSpecMigrationsMap()} instead.
     */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> getThreadSpecMigrations() {
      return getThreadSpecMigrationsMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    @java.lang.Override
    public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> getThreadSpecMigrationsMap() {
      return internalGetThreadSpecMigrations().getMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    @java.lang.Override
    public /* nullable */
io.littlehorse.sdk.common.proto.ThreadSpecMigration getThreadSpecMigrationsOrDefault(
        java.lang.String key,
        /* nullable */
io.littlehorse.sdk.common.proto.ThreadSpecMigration defaultValue) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> map =
          internalGetThreadSpecMigrations().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    @java.lang.Override
    public io.littlehorse.sdk.common.proto.ThreadSpecMigration getThreadSpecMigrationsOrThrow(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> map =
          internalGetThreadSpecMigrations().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }
    public Builder clearThreadSpecMigrations() {
      bitField0_ = (bitField0_ & ~0x00000002);
      internalGetMutableThreadSpecMigrations().getMutableMap()
          .clear();
      return this;
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    public Builder removeThreadSpecMigrations(
        java.lang.String key) {
      if (key == null) { throw new NullPointerException("map key"); }
      internalGetMutableThreadSpecMigrations().getMutableMap()
          .remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration>
        getMutableThreadSpecMigrations() {
      bitField0_ |= 0x00000002;
      return internalGetMutableThreadSpecMigrations().getMutableMap();
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    public Builder putThreadSpecMigrations(
        java.lang.String key,
        io.littlehorse.sdk.common.proto.ThreadSpecMigration value) {
      if (key == null) { throw new NullPointerException("map key"); }
      if (value == null) { throw new NullPointerException("map value"); }
      internalGetMutableThreadSpecMigrations().getMutableMap()
          .put(key, value);
      bitField0_ |= 0x00000002;
      return this;
    }
    /**
     * <code>map&lt;string, .littlehorse.ThreadSpecMigration&gt; thread_spec_migrations = 2;</code>
     */
    public Builder putAllThreadSpecMigrations(
        java.util.Map<java.lang.String, io.littlehorse.sdk.common.proto.ThreadSpecMigration> values) {
      internalGetMutableThreadSpecMigrations().getMutableMap()
          .putAll(values);
      bitField0_ |= 0x00000002;
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:littlehorse.WfSpecVersionMigration)
  }

  // @@protoc_insertion_point(class_scope:littlehorse.WfSpecVersionMigration)
  private static final io.littlehorse.sdk.common.proto.WfSpecVersionMigration DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.littlehorse.sdk.common.proto.WfSpecVersionMigration();
  }

  public static io.littlehorse.sdk.common.proto.WfSpecVersionMigration getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<WfSpecVersionMigration>
      PARSER = new com.google.protobuf.AbstractParser<WfSpecVersionMigration>() {
    @java.lang.Override
    public WfSpecVersionMigration parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<WfSpecVersionMigration> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<WfSpecVersionMigration> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.littlehorse.sdk.common.proto.WfSpecVersionMigration getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

