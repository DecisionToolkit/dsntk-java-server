package io.dsntk.server.common;

import io.dsntk.server.rest.errors.RpcException;

public enum CastType {
  CT_BYTE,
  CT_SHORT,
  CT_INT,
  CT_LONG,
  CT_FLOAT,
  CT_DOUBLE,
  CT_CHAR,
  CT_BOOLEAN,
  CT_STRING,
  CT_OBJECT_ARRAY;

  public boolean isPrimitive() {
    return this == CT_BYTE ||
      this == CT_SHORT ||
      this == CT_INT ||
      this == CT_LONG ||
      this == CT_FLOAT ||
      this == CT_DOUBLE ||
      this == CT_CHAR ||
      this == CT_BOOLEAN ||
      this == CT_STRING;
  }

  public static CastType fromClass(Class<?> clazz) throws RpcException {
    switch (clazz.getName()) {
      case "byte", "java.lang.Byte" -> {
        return CT_BYTE;
      }
      case "short", "java.lang.Short" -> {
        return CT_SHORT;
      }
      case "int", "java.lang.Integer" -> {
        return CT_INT;
      }
      case "long", "java.lang.Long" -> {
        return CT_LONG;
      }
      case "float", "java.lang.Float" -> {
        return CT_FLOAT;
      }
      case "double", "java.lang.Double" -> {
        return CT_DOUBLE;
      }
      case "char", "java.lang.Character" -> {
        return CT_CHAR;
      }
      case "boolean", "java.lang.Boolean" -> {
        return CT_BOOLEAN;
      }
      case "java.lang.String" -> {
        return CT_STRING;
      }
      case "[Ljava.lang.Object;" -> {
        return CT_OBJECT_ARRAY;
      }
    }
    throw new RpcException(String.format("invalid cast class: %s", clazz.getName()));
  }
}
