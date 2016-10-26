package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.models.User;
import ru.itis.inform.services.UserService;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements UserDAO {
  private String query;
  private UserService userService;

  public User find(String login) {

    try {

      query = "SELECT * FROM Customers WHERE login = ?;";

      Statement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
      ConnectionFactory.statement.setString(1, login);

      ResultSet resultSet = ConnectionFactory.statement.executeQuery();

      while (resultSet.next()) {
        return new User(resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("fio"), resultSet.getString("address"), resultSet.getString("phone"));
      }
    } catch (Exception e) {
      System.out.println("Error.");
    }

    return null;
  }

  public void save(User user) {

    query = "INSERT INTO customers (id, login, password, fio, address, phone) VALUES ( ? , ? , ? , ? , ? , ?);";

    try {

      PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      statement.setInt(1, user.getId());
      statement.setString(2, user.getLogin());
      statement.setString(3, user.getPassword());
      statement.setString(4, user.getFIO());
      statement.setString(5, user.getAddress());
      statement.setString(6, user.getPhone());

      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public List<User> findAll() {
    return null;
  }
}
