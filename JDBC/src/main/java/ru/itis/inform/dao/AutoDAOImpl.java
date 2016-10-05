package ru.itis.inform.dao;

import java.sql.*;
import java.util.LinkedList;

public class AutoDAOImpl implements AutoDAO {
  private final String URL = "jdbc:postgresql://localhost:5432/inform";
  private final String USER = "farkh";
  private final String PASSWORD = "5555";
  private Connection connection;
  private Statement statement;

  public AutoDAOImpl() {
    this.connection = null;

    try {
      Class.forName("org.postgresql.Driver");
      System.out.println("Driver connected.");
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
      this.statement = connection.createStatement();
    } catch (Exception e) {
      System.out.println("Something went wrong :(");
    } finally {
      if (connection != null) {
        System.out.println("Connection exists.");
        try {
          connection.close();
          statement.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  public LinkedList<Auto> findAll() throws SQLException {
    LinkedList<Auto> linkedList = new LinkedList<Auto>();
    Auto auto;
    connection = DriverManager.getConnection(URL, USER, PASSWORD);
    String query = "SELECT * FROM auto;";
    statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query);

    while (resultSet.next()) {
      auto = new Auto(resultSet.getInt("auto_id"), resultSet.getString("auto_name"));
      linkedList.add(auto);
    }

    return linkedList;
  }

  public void save(Auto auto) throws SQLException {
    connection = DriverManager.getConnection(URL, USER, PASSWORD);
    statement = connection.createStatement();
    String query = "INSERT INTO auto VALUES (" + auto.getId() + ", " + auto.getName() + ");";
    ResultSet resultSet = statement.executeQuery(query);
  }
}