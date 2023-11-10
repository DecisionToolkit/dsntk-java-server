package io.dsntk.server.common;

import io.dsntk.server.rest.errors.RpcException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XsdTypeTest {

  @Test
  public void invalidXsdTypeShouldThrowException() {
    RpcException thrown = assertThrows(RpcException.class, () -> {
      XsdType.fromString("xsd:map");
    }, "RpcException was expected");
    assertEquals("invalid XSD type name: xsd:map", thrown.getMessage());
  }

  @Test
  public void legalXsdTypes() throws RpcException {
    assertEquals(XsdType.XSD_STRING, XsdType.fromString("xsd:string"));
    assertEquals(XsdType.XSD_INTEGER, XsdType.fromString("xsd:integer"));
    assertEquals(XsdType.XSD_DECIMAL, XsdType.fromString("xsd:decimal"));
    assertEquals(XsdType.XSD_DOUBLE, XsdType.fromString("xsd:double"));
    assertEquals(XsdType.XSD_BOOLEAN, XsdType.fromString("xsd:boolean"));
    assertEquals(XsdType.XSD_DATE, XsdType.fromString("xsd:date"));
    assertEquals(XsdType.XSD_TIME, XsdType.fromString("xsd:time"));
    assertEquals(XsdType.XSD_DATE_TIME, XsdType.fromString("xsd:dateTime"));
    assertEquals(XsdType.XSD_DURATION, XsdType.fromString("xsd:duration"));
  }
}
