package io.dsntk.server.rest.controllers;

import io.dsntk.server.rest.dto.ResultDto;
import io.dsntk.server.rest.dto.ValueDto;
import io.dsntk.server.rest.errors.RpcException;
import io.dsntk.server.rest.params.RpcParams;
import io.dsntk.server.services.RpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Java RPC controller.
 */
@Slf4j
@RestController
@RequestMapping(RequestMappings.M_RPC_SERVER)
public class RpcController {

  private final RpcService rpcService;

  /** Initializes RPC controller. */
  public RpcController(RpcService rpcService) {
    this.rpcService = rpcService;
  }

  /**
   * Returns system info.
   *
   * @return System info DTO wrapped in ResultDTO.
   */
  @PostMapping(RequestMappings.M_V1 + RequestMappings.M_RPC_EVALUATE)
  public ResultDto<ValueDto> evaluate(@RequestBody RpcParams params) throws RpcException {
    return new ResultDto<>(this.rpcService.evaluate(params.getClassName(), params.getMethodName(), params.getParameterTypes(), params.getArguments()));
  }
}
