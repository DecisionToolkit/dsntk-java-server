package org.decisiontoolkit.server.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

  @Test
  void endingZeroShouldBeStrippedOff() {
    assertEquals("457", Utils.stripTrailingZero(String.format("%s", 457)));
    assertEquals("457", Utils.stripTrailingZero(String.format("%s", 457F)));
  }

  @Test
  void endingWithoutZeroShouldBeLeft() {
    assertEquals("457.12", Utils.stripTrailingZero(String.format("%s", 457.1200000)));
    assertEquals("457.12", Utils.stripTrailingZero(String.format("%s", 457.1200000F)));
  }
}