package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO representing a component of the object value.
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class ComponentDto {

  /** Name of the value's component. */
  @JsonProperty("name")
  private String name;

  /** Value of the component. */
  @JsonProperty("value")
  private ValueDto value;

  /** Flag indicating if the value of the component is `nil`. */
  @JsonProperty("isNil")
  private boolean nil;
}
