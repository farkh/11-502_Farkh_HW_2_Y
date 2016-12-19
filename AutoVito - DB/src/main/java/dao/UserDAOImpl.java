package dao;

import factories.ConnectionFactory;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImpl implements UserDAO {
  private String query;

  public UserDAOImpl() { this.query = ""; }

  public User find(String login) {

    Statement statement;
    User resCustomer = null;
    try {

      String checkLogin;
      query = "SELECT * FROM users;";

      statement = ConnectionFactory.getInstance().getConnection().createStatement();

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        checkLogin = resultSet.getString("login");
        if (login.equals(checkLogin)) {
          resCustomer = new User(resultSet.getString("login"), resultSet.getString("password"));
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Error, find() doesn't work :(");
    }

    return resCustomer;
  }

  public void save(User user) throws SQLException {
    query = "INSERT INTO users (login, password) VALUES (?, ?)";

    PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

    statement.setString(1, user.getLogin());
    statement.setString(2, user.getPassword());

    statement.executeUpdate();
  }

  public List<User> findAll() {
    return null;
  }
}
