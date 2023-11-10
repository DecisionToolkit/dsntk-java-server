package io.dsntk.server.rest.params;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dsntk.server.rest.dto.ValueDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class RpcParams {
  /** Name of the class where called static method is defined. */
  @JsonProperty("className")
  private String className;

  /** Name of the method to be called. */
  @JsonProperty("methodName")
  private String methodName;

  @JsonProperty("parameterTypes")
  private ArrayList<String> parameterTypes;

  @JsonProperty("arguments")
  private ArrayList<ValueDto> arguments;
}
