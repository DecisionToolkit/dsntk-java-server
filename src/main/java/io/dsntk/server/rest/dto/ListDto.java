package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * DTO representing a list of values.
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ListDto {

  /** Items in the list ov values. */
  @JsonProperty("items")
  private ArrayList<ValueDto> items;

  /** Flag indicating if the value is of the list is `nil`. */
  @JsonProperty("isNil")
  private boolean nil;
}
