package com.zoo.panda.util;

public class StringUtils {
  public static boolean isNullOrEmpty(Object obj) {
    return obj == null || obj.toString().length() == 0 || "null".equals(obj.toString()) || obj.toString().trim().length() == 0;
  }
}
