package io.dsntk.server.rest.controllers;

import io.dsntk.server.rest.dto.ResultDto;
import io.dsntk.server.rest.dto.SystemInfoDto;
import io.dsntk.server.rest.dto.SystemInfoDtoFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * System controller.
 */
@Slf4j
@RestController
@RequestMapping(RequestMappings.M_RPC_SERVER)
public class SystemController {

  @Value("${app.version}")
  private String appVersion;

  @Value("${app.name}")
  private String appName;

  /** Factory for system info DTO. */
  private final SystemInfoDtoFactory systemInfoDtoFactory;

  /**
   * Initializes system controller.
   *
   * @param systemInfoDtoFactory Factory for system info DTO.
   */
  public SystemController(SystemInfoDtoFactory systemInfoDtoFactory) {
    this.systemInfoDtoFactory = systemInfoDtoFactory;
  }

  /**
   * Returns system info.
   *
   * @return System info DTO wrapped in ResultDTO.
   */
  @GetMapping(RequestMappings.M_V1 + RequestMappings.M_SYSTEM_INFO)
  public ResultDto<SystemInfoDto> getSystemInfo() {
    return this.systemInfoDtoFactory.from(appName, appVersion);
  }
}
