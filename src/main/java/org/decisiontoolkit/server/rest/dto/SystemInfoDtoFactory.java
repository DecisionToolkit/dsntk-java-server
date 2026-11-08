package org.decisiontoolkit.server.rest.dto;

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
        return new ResultDto<>(new SystemInfoDto(name, version));
    }
}
