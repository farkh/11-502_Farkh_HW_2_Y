package services;

import models.User;

public interface UserService {
  boolean isRegistered(String login);
  User findUser(String login);
}
