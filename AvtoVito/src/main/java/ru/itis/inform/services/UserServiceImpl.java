package ru.itis.inform.services;

import ru.itis.inform.dao.UserDAO;
import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceImpl implements UserService {
  private UserDAO userDAO = null;


  public boolean isRegistered(String login) {

    String query = "";
    Boolean registered = false;
    Statement statement = null;
    try {

      query = "SELECT login FROM Customers;";
      statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
      ResultSet resultSet = ConnectionFactory.statement.executeQuery();

      while(resultSet.next()) {
        if (login.equals(resultSet.getString("login"))) {
          registered = true;
          break;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return registered;
  }

  public boolean isRightPassword(String login, String password) {

    Boolean right = false;

    try {
      String query = "SELECT login, password FROM Customers;";

      Statement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      ResultSet resultSet = ConnectionFactory.statement.executeQuery();

      while(resultSet.next()) {
        if (isRegistered(login) & password.equals(resultSet.getString("password"))) {
          right = true;
          break;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return right;
  }

  public void saveUser(User user) {

  }

  public User findUser(String login) {

    return userDAO.find(login);
//
//    if (userDAO.find(login) != null) {
//      return userDAO.find(login);
//    } else {
//      return null;
//    }
  }
}
