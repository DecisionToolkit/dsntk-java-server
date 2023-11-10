package io.dsntk.server.rest.controllers;

/**
 * Request mapping definitions.
 */
public interface RequestMappings {
  String M_ROOT = "/";

  String M_API_REST = M_ROOT + "api/rest";

  String M_V1 = "/v1";

  String M_SYSTEM = "/system";

  String M_SYSTEM_INFO = M_SYSTEM + "/info";

  String M_RPC = "/rpc";

  String M_RPC_EVALUATE = M_RPC + "/evaluate";

  String M_RPC_SERVER = M_API_REST;
}
