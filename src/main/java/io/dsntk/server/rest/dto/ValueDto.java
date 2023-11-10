package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dsntk.server.common.CastType;
import io.dsntk.server.rest.errors.RpcException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * DTO representing a FEEL value.
 */
@Getter
@Setter
public class ValueDto {

  /** Simple value. */
  @JsonProperty("simple")
  private SimpleDto simple;

  /** Object value. */
  @JsonProperty("components")
  private ArrayList<ComponentDto> object;

  /** List value. */
  @JsonProperty("list")
  private ListDto list;

  public Object toObject(Class<?> castClass) throws RpcException {
    if (this.simple != null) {
      return this.simple.toObject(castClass);
    }
    return null;
  }

  public static ValueDto fromObject(Object object) throws RpcException {
    CastType castType = CastType.fromClass(object.getClass());
    if (castType.isPrimitive()) {
      return simple(object, castType);
    }
    throw new RpcException(String.format("value conversion failed from object class %s", object.getClass().getName()));
  }

  private static ValueDto simple(Object object, CastType castType) throws RpcException {
    ValueDto valueDto = new ValueDto();
    valueDto.simple = SimpleDto.fromObject(object, castType);
    return valueDto;
  }
}
