package ru.itis.inform.dao;

import java.sql.*;
import java.util.LinkedList;

public class UserDAOImpl implements UserDAO {
  private final String URL = "jdbc:postgresql://localhost:5432/inform";
  private final String USER = "farkh";
  private final String PASSWORD = "5555";
  private Connection connection;
  private Statement statement;

  public UserDAOImpl() {
    this.connection = null;

    try {
      System.out.println("Before forName");
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver connected");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      this.statement = connection.createStatement();
    } catch (Exception e) {
      System.out.println("Something went wrong");
    } finally {
      if (connection != null) {
        System.out.println("Not 'null'");
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public LinkedList<User> findAll() throws SQLException {
    connection = DriverManager.getConnection(URL, USER, PASSWORD);
    LinkedList<User> linkedList = new LinkedList<User>();
    User user;
    String query = "SELECT * FROM users;";
    statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query);

    while (resultSet.next()) {
      user = new User(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getInt("age"), resultSet.getString("city"));
      linkedList.add(user);
    }

    return linkedList;
  }

  public void save(User user) throws SQLException {
    connection = DriverManager.getConnection(URL, USER, PASSWORD);
    statement = connection.createStatement();
    String query = "INSERT INTO users VALUES (" + user.getId() + ", " + user.getName() + ");";
    ResultSet resultSet = statement.executeQuery(query);
  }
}