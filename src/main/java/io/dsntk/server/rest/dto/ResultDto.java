package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Result DTO.
 *
 * @param <T> Type of the data being transmitted as a result.
 */
@Getter
public class ResultDto<T> {

  /** Data sent as a result. */
  @JsonProperty("data")
  private T data;

  /**
   * Creates a new DTO object containing result data.
   *
   * @param data Result data.
   */
  public ResultDto(T data) {
    this.data = data;
  }
}

