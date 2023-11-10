package io.dsntk.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dsntk.server.common.CastType;
import io.dsntk.server.common.Utils;
import io.dsntk.server.common.XsdType;
import io.dsntk.server.rest.errors.RpcException;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

/**
 * DTO representing a simple type value.
 */
@Getter
@Setter
public class SimpleDto {

  /** Name of the value's type. */
  @JsonProperty("type")
  private String typ;

  /** Value represented as text. */
  @JsonProperty("text")
  private String text;

  /** Flag indicating if the value is `nil`. */
  @JsonProperty("isNil")
  private boolean nil;

  public Object toObject(Class<?> castClass) throws RpcException {
    CastType castType = CastType.fromClass(castClass);
    XsdType xsdType = XsdType.fromString(this.typ);
    switch (xsdType) {
      case XSD_STRING -> {
        if (castType == CastType.CT_STRING) {
          return this.text;
        }
        if (castType == CastType.CT_CHAR) {
          if (this.text.length() == 1) {
            return this.text.charAt(0);
          }
        }
        if (castType == CastType.CT_OBJECT_ARRAY) {
          String[] arr = (String[]) Array.newInstance(java.lang.String.class, 1);
          Array.set(arr, 0, this.text);
          return arr;
        }
      }
      case XSD_INTEGER -> {
        if (castType == CastType.CT_BYTE) {
          return Byte.valueOf(this.text);
        }
        if (castType == CastType.CT_SHORT) {
          return Short.valueOf(this.text);
        }
        if (castType == CastType.CT_INT) {
          return Integer.valueOf(this.text);
        }
        if (castType == CastType.CT_LONG) {
          return Long.valueOf(this.text);
        }
      }
      case XSD_DOUBLE -> {
        if (castType == CastType.CT_FLOAT) {
          return Float.valueOf(this.text);
        }
        if (castType == CastType.CT_DOUBLE) {
          return Double.valueOf(this.text);
        }
      }
      case XSD_DECIMAL -> {
        if (castType == CastType.CT_BYTE) {
          return Byte.valueOf(this.text);
        }
        if (castType == CastType.CT_SHORT) {
          return Short.valueOf(this.text);
        }
        if (castType == CastType.CT_INT) {
          return Integer.valueOf(this.text);
        }
        if (castType == CastType.CT_LONG) {
          return Long.valueOf(this.text);
        }
        if (castType == CastType.CT_FLOAT) {
          return Float.valueOf(this.text);
        }
        if (castType == CastType.CT_DOUBLE) {
          return Double.valueOf(this.text);
        }
      }
    }
    throw new RpcException(String.format("simple DTO conversion to object failed, class: %s, type: %s", castClass.getName(), xsdType));
  }

  public static SimpleDto fromObject(Object object, CastType castType) throws RpcException {
    switch (castType) {
      case CT_BYTE -> {
        return SimpleDto.fromByte((Byte) object);
      }
      case CT_SHORT -> {
        return SimpleDto.fromShort((Short) object);
      }
      case CT_INT -> {
        return SimpleDto.fromInteger((Integer) object);
      }
      case CT_LONG -> {
        return SimpleDto.fromLong((Long) object);
      }
      case CT_FLOAT -> {
        return SimpleDto.fromFloat((Float) object);
      }
      case CT_DOUBLE -> {
        return SimpleDto.fromDouble((Double) object);
      }
      case CT_CHAR -> {
        return SimpleDto.fromCharacter((Character) object);
      }
      case CT_STRING -> {
        return SimpleDto.fromString((String) object);
      }
    }
    throw new RpcException(String.format("simple DTO conversion from object failed, class: %s, type: %s", object.getClass().getName(), castType));
  }

  private static SimpleDto fromByte(Byte object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:decimal";
    value.text = String.valueOf(object);
    value.nil = false;
    return value;
  }

  private static SimpleDto fromShort(Short object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:decimal";
    value.text = String.valueOf(object);
    value.nil = false;
    return value;
  }

  private static SimpleDto fromInteger(Integer object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:decimal";
    value.text = String.valueOf(object);
    value.nil = false;
    return value;
  }

  private static SimpleDto fromLong(Long object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:decimal";
    value.text = String.valueOf(object);
    value.nil = false;
    return value;
  }

  private static SimpleDto fromFloat(Float object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:decimal";
    value.text = Utils.stripTrailingZero(String.format("%s", object));
    value.nil = false;
    return value;
  }

  private static SimpleDto fromDouble(Double object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:decimal";
    value.text = Utils.stripTrailingZero(String.format("%s", object));
    value.nil = false;
    return value;
  }

  private static SimpleDto fromCharacter(Character object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:string";
    value.text = String.valueOf(object);
    value.nil = false;
    return value;
  }

  private static SimpleDto fromString(String object) {
    SimpleDto value = new SimpleDto();
    value.typ = "xsd:string";
    value.text = object;
    value.nil = false;
    return value;
  }
}
