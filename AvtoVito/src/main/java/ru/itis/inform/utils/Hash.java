package ru.itis.inform.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

  public String generateHash(String password) {

    String hash = null;

    try {
      byte[] bytes = password.getBytes("UTF-8");
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");

      byte[] hashBytes = messageDigest.digest(bytes);
      char[] hashChars = new char[hashBytes.length];

      for (int i = 0; i < hashBytes.length; i++) {
        hashChars[i] = (char) hashBytes[i];
      }

      hash = String.valueOf(hashChars);

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return hash;
  }
}