package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
  User find(String login);
  void save(User user) throws SQLException;
  List<User> findAll();
}
