package ru.itis.inform.services;

import ru.itis.inform.models.User;

public interface UserService {
  boolean isRegistered(String login);
  void saveUser(User user);
  User findUser();
}