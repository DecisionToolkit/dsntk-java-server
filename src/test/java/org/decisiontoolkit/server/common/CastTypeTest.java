package org.decisiontoolkit.server.common;

import org.decisiontoolkit.server.rest.errors.RpcException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CastTypeTest {

  @Test
  void invalidCastTypeShouldThrowException() throws ClassNotFoundException {
    Class<?> clazz = Class.forName("java.util.HashSet");
    RpcException thrown = assertThrows(RpcException.class, () -> {
      CastType.fromClass(clazz);
    }, "RpcException was expected");
    assertEquals("invalid cast class: java.util.HashSet", thrown.getMessage());
  }

  @Test
  void primitiveTypes() throws RpcException {
    assertEquals(CastType.CT_BYTE, CastType.fromClass(byte.class));
    assertEquals(CastType.CT_SHORT, CastType.fromClass(short.class));
    assertEquals(CastType.CT_INT, CastType.fromClass(int.class));
    assertEquals(CastType.CT_LONG, CastType.fromClass(long.class));
    assertEquals(CastType.CT_FLOAT, CastType.fromClass(float.class));
    assertEquals(CastType.CT_DOUBLE, CastType.fromClass(double.class));
    assertEquals(CastType.CT_CHAR, CastType.fromClass(char.class));
    assertEquals(CastType.CT_BOOLEAN, CastType.fromClass(boolean.class));
  }

  @Test
  void primitiveObjectTypes() throws RpcException {
    assertEquals(CastType.CT_BYTE, CastType.fromClass(java.lang.Byte.class));
    assertEquals(CastType.CT_SHORT, CastType.fromClass(java.lang.Short.class));
    assertEquals(CastType.CT_INT, CastType.fromClass(java.lang.Integer.class));
    assertEquals(CastType.CT_LONG, CastType.fromClass(java.lang.Long.class));
    assertEquals(CastType.CT_FLOAT, CastType.fromClass(java.lang.Float.class));
    assertEquals(CastType.CT_DOUBLE, CastType.fromClass(java.lang.Double.class));
    assertEquals(CastType.CT_CHAR, CastType.fromClass(java.lang.Character.class));
    assertEquals(CastType.CT_BOOLEAN, CastType.fromClass(java.lang.Boolean.class));
    assertEquals(CastType.CT_STRING, CastType.fromClass(java.lang.String.class));
  }

  @Test
  void arrayTypes() throws RpcException {
    assertEquals(CastType.CT_OBJECT_ARRAY, CastType.fromClass(Object[].class));
  }

  @Test
  void checkPrimitiveTypes() {
    assertTrue(CastType.CT_BYTE.isPrimitive());
    assertFalse(CastType.CT_OBJECT_ARRAY.isPrimitive());
  }
}
