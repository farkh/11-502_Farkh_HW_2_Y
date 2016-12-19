package services;

import models.Customer;

public interface CustomerService {
  boolean isRegistered(String login);
  boolean isRightPassword(String login, String password);
}
