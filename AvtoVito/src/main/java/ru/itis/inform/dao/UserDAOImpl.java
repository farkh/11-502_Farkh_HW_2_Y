package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.models.User;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements UserDAO {
  private String query;

  public UserDAOImpl() {
    this.query = "";
  }

  public User find(String login) {
    Statement statement;
    User resUser = null;
    try {

      String checkLogin;
      query = "SELECT * FROM customers;";

      ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
      statement = connectionFactory.getConnection().createStatement();

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        checkLogin = resultSet.getString("login");
        if (login.equals(checkLogin)) {
          resUser = new User(resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("fio"), resultSet.getString("address"), resultSet.getString("phone"));
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Error, find() doesn't work :(");
    }

    return resUser;
  }

  public void save(User user) throws SQLException {

    query = "INSERT INTO customers (id, login, password, fio, address, phone) VALUES ( ? , ? , ? , ? , ? , ?);";

    PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

    statement.setInt(1, user.getId());
    statement.setString(2, user.getLogin());
    statement.setString(3, user.getPassword());
    statement.setString(4, user.getFIO());
    statement.setString(5, user.getAddress());
    statement.setString(6, user.getPhone());

    statement.executeUpdate();
  }

  public List<User> findAll() {
    return null;
  }
}
