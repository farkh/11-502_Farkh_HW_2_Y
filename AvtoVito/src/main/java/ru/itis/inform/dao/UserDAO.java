package ru.itis.inform.dao;

import ru.itis.inform.models.User;
import java.util.List;

public interface UserDAO {
  User find(String login);
  void save(User user);
  List<User> findAll();
}
