package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
  User find(String login);
  void save(User user) throws SQLException;
  List<User> findAll();
  String isExists(String token);
  String findByID(String id);
}
