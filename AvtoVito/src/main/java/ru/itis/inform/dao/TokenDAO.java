package ru.itis.inform.dao;

public interface TokenDAO {

  void addToken(String id, String token);
  void updateToken(String id, String token);
  void deleteToken(String token);
  String findToken(String token);
}
