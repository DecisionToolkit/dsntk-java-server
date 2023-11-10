package io.dsntk.server.rest.dto;

import org.springframework.stereotype.Service;

/**
 * Factory for system info DTOs.
 */
@Service
public class SystemInfoDtoFactory {

  /**
   * Creates DTO object containing system info.
   *
   * @param name    Application name.
   * @param version Application version.
   * @return Result DTO.
   */
  public ResultDto<SystemInfoDto> from(String name, String version) {
    SystemInfoDto dto = new SystemInfoDto();
    dto.setName(name);
    dto.setVersion(version);
    return new ResultDto<>(dto);
  }
}
