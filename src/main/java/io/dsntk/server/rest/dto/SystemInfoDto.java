package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * System info DTO.
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class SystemInfoDto {

  /** Application name. */
  @JsonProperty("name")
  private String name;

  /** Application version. */
  @JsonProperty("version")
  private String version;

}
