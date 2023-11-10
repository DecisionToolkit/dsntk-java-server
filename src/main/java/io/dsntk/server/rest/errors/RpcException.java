package io.dsntk.server.rest.errors;

public class RpcException extends Exception {

  /**
   * Creates RPC exception.
   *
   * @param details Reason of the exception.
   */
  public RpcException(String details) {
    super(details);
  }
}