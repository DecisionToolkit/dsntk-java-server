package io.dsntk.server.common;

import io.dsntk.server.rest.errors.RpcException;

public enum XsdType {
  XSD_STRING,
  XSD_INTEGER,
  XSD_DECIMAL,
  XSD_DOUBLE,
  XSD_BOOLEAN,
  XSD_DATE,
  XSD_DATE_TIME,
  XSD_TIME,
  XSD_DURATION;

  /**
   * Returns XSD type created from its textual representation.
   *
   * @param typeName Name of the XSD type.
   * @return XSD type enumeration instance.
   * @throws RpcException when the name of the type is invalid.
   */
  public static XsdType fromString(String typeName) throws RpcException {
    return switch (typeName) {
      case "xsd:integer" -> XsdType.XSD_INTEGER;
      case "xsd:double" -> XsdType.XSD_DOUBLE;
      case "xsd:decimal" -> XsdType.XSD_DECIMAL;
      case "xsd:string" -> XsdType.XSD_STRING;
      case "xsd:boolean" -> XsdType.XSD_BOOLEAN;
      case "xsd:date" -> XsdType.XSD_DATE;
      case "xsd:time" -> XsdType.XSD_TIME;
      case "xsd:dateTime" -> XsdType.XSD_DATE_TIME;
      case "xsd:duration" -> XsdType.XSD_DURATION;
      default -> throw new RpcException(String.format("invalid XSD type name: %s", typeName));
    };
  }
}