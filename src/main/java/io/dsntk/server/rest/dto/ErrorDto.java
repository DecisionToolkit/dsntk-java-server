package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {

  /** Error details. */
  @JsonProperty("error")
  private String details;

  /**
   * Creates new error DTO with detailed message.
   *
   * @param details Error details.
   * @return Error DTO.
   */
  public static ErrorDto createFrom(String details) {
    ErrorDto dto = new ErrorDto();
    dto.setDetails(details);
    return dto;
  }
}