package io.dsntk.server.common;

/**
 * Utilities.
 */
public class Utils {
  /**
   * When the input string ends with `.0`, then strips this off.
   *
   * @param input String to be stripped off.
   * @return Stripped string.
   */
  public static String stripTrailingZero(String input) {
    if (input.endsWith(".0")) {
      return input.substring(0, input.length() - 2);
    } else {
      return input;
    }
  }
}
