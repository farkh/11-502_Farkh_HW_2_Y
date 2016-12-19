package services;

import dao.UserDAO;
import dao.UserDAOImpl;
import factories.ConnectionFactory;
import models.User;

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

      query = "SELECT login FROM users;";
      statement = ConnectionFactory.getInstance().getConnection().createStatement();
      ResultSet resultSet = statement.executeQuery(query);

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
      String query = "SELECT login, password FROM users;";
      Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
      ResultSet resultSet = statement.executeQuery(query);

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

  public User findUser(String login) {
    User user = null;
    userDAO = new UserDAOImpl();

    if (userDAO.find(login) != null) {
      user =  userDAO.find(login);
    }

    return user;
  }
}
