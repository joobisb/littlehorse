// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: acls.proto

package io.littlehorse.sdk.common.proto;

public final class Acls {
  private Acls() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_Principal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_Principal_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_Principal_PerTenantAclsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_Principal_PerTenantAclsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_Tenant_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_Tenant_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_ServerACLs_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_ServerACLs_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_ServerACL_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_ServerACL_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_PutPrincipalRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_PutPrincipalRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_PutPrincipalRequest_PerTenantAclsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_PutPrincipalRequest_PerTenantAclsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_DeletePrincipalRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_DeletePrincipalRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_littlehorse_PutTenantRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_littlehorse_PutTenantRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nacls.proto\022\013littlehorse\032\037google/protob" +
      "uf/timestamp.proto\032\017object_id.proto\"\242\002\n\t" +
      "Principal\022$\n\002id\030\001 \001(\0132\030.littlehorse.Prin" +
      "cipalId\022.\n\ncreated_at\030\002 \001(\0132\032.google.pro" +
      "tobuf.Timestamp\022B\n\017per_tenant_acls\030\003 \003(\013" +
      "2).littlehorse.Principal.PerTenantAclsEn" +
      "try\022,\n\013global_acls\030\004 \001(\0132\027.littlehorse.S" +
      "erverACLs\032M\n\022PerTenantAclsEntry\022\013\n\003key\030\001" +
      " \001(\t\022&\n\005value\030\002 \001(\0132\027.littlehorse.Server" +
      "ACLs:\0028\001\"[\n\006Tenant\022!\n\002id\030\001 \001(\0132\025.littleh" +
      "orse.TenantId\022.\n\ncreated_at\030\002 \001(\0132\032.goog" +
      "le.protobuf.Timestamp\"2\n\nServerACLs\022$\n\004a" +
      "cls\030\001 \003(\0132\026.littlehorse.ServerACL\"\236\001\n\tSe" +
      "rverACL\022+\n\tresources\030\001 \003(\0162\030.littlehorse" +
      ".ACLResource\022/\n\017allowed_actions\030\002 \003(\0162\026." +
      "littlehorse.ACLAction\022\016\n\004name\030\003 \001(\tH\000\022\020\n" +
      "\006prefix\030\004 \001(\tH\000B\021\n\017resource_filter\"\377\001\n\023P" +
      "utPrincipalRequest\022\n\n\002id\030\001 \001(\t\022L\n\017per_te" +
      "nant_acls\030\002 \003(\01323.littlehorse.PutPrincip" +
      "alRequest.PerTenantAclsEntry\022,\n\013global_a" +
      "cls\030\003 \001(\0132\027.littlehorse.ServerACLs\022\021\n\tov" +
      "erwrite\030\005 \001(\010\032M\n\022PerTenantAclsEntry\022\013\n\003k" +
      "ey\030\001 \001(\t\022&\n\005value\030\002 \001(\0132\027.littlehorse.Se" +
      "rverACLs:\0028\001\"$\n\026DeletePrincipalRequest\022\n" +
      "\n\002id\030\001 \001(\t\"\036\n\020PutTenantRequest\022\n\n\002id\030\001 \001" +
      "(\t*\222\001\n\013ACLResource\022\020\n\014ACL_WORKFLOW\020\000\022\014\n\010" +
      "ACL_TASK\020\001\022\026\n\022ACL_EXTERNAL_EVENT\020\002\022\021\n\rAC" +
      "L_USER_TASK\020\003\022\021\n\rACL_PRINCIPAL\020\004\022\016\n\nACL_" +
      "TENANT\020\005\022\025\n\021ACL_ALL_RESOURCES\020\006*C\n\tACLAc" +
      "tion\022\010\n\004READ\020\000\022\007\n\003RUN\020\001\022\022\n\016WRITE_METADAT" +
      "A\020\002\022\017\n\013ALL_ACTIONS\020\003BG\n\037io.littlehorse.s" +
      "dk.common.protoP\001Z\007.;model\252\002\030LittleHorse" +
      ".Common.Protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          io.littlehorse.sdk.common.proto.ObjectId.getDescriptor(),
        });
    internal_static_littlehorse_Principal_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_littlehorse_Principal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_Principal_descriptor,
        new java.lang.String[] { "Id", "CreatedAt", "PerTenantAcls", "GlobalAcls", });
    internal_static_littlehorse_Principal_PerTenantAclsEntry_descriptor =
      internal_static_littlehorse_Principal_descriptor.getNestedTypes().get(0);
    internal_static_littlehorse_Principal_PerTenantAclsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_Principal_PerTenantAclsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_littlehorse_Tenant_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_littlehorse_Tenant_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_Tenant_descriptor,
        new java.lang.String[] { "Id", "CreatedAt", });
    internal_static_littlehorse_ServerACLs_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_littlehorse_ServerACLs_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_ServerACLs_descriptor,
        new java.lang.String[] { "Acls", });
    internal_static_littlehorse_ServerACL_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_littlehorse_ServerACL_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_ServerACL_descriptor,
        new java.lang.String[] { "Resources", "AllowedActions", "Name", "Prefix", "ResourceFilter", });
    internal_static_littlehorse_PutPrincipalRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_littlehorse_PutPrincipalRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_PutPrincipalRequest_descriptor,
        new java.lang.String[] { "Id", "PerTenantAcls", "GlobalAcls", "Overwrite", });
    internal_static_littlehorse_PutPrincipalRequest_PerTenantAclsEntry_descriptor =
      internal_static_littlehorse_PutPrincipalRequest_descriptor.getNestedTypes().get(0);
    internal_static_littlehorse_PutPrincipalRequest_PerTenantAclsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_PutPrincipalRequest_PerTenantAclsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_littlehorse_DeletePrincipalRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_littlehorse_DeletePrincipalRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_DeletePrincipalRequest_descriptor,
        new java.lang.String[] { "Id", });
    internal_static_littlehorse_PutTenantRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_littlehorse_PutTenantRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_littlehorse_PutTenantRequest_descriptor,
        new java.lang.String[] { "Id", });
    com.google.protobuf.TimestampProto.getDescriptor();
    io.littlehorse.sdk.common.proto.ObjectId.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
