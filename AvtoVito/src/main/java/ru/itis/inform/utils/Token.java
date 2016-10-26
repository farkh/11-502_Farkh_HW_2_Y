package ru.itis.inform.utils;

import java.security.SecureRandom;

public class Token {

  public static String getToken() {
    SecureRandom secureRandom = new SecureRandom();
    byte bytes[] = new byte[20];
    secureRandom.nextBytes(bytes);
    String token = bytes.toString();
    return token;
  }
}