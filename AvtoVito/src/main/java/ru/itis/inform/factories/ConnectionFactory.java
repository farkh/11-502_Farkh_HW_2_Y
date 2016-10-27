package ru.itis.inform.factories;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {

  private static ConnectionFactory instance;
  private Properties properties;
  public static PreparedStatement statement;

  private Connection connection;
  private String driverClass;
  private String urlDB;
  private String userDB;
  private String passwordDB;

  private ConnectionFactory() {

    try {
      this.properties = new Properties();
      properties.load(new FileInputStream("/Users/farkh/Programming/11-502_Farkh_HW_2_Y/AvtoVito/src/main/resources/drivers.properties"));

      this.driverClass = properties.getProperty("driver.class");
      this.urlDB = properties.getProperty("urlDB.string");
      this.userDB = properties.getProperty("userDB.string");
      this.passwordDB = properties.getProperty("passwordDB.string");

      System.out.println("Connection: true");

      Class.forName(driverClass);
      connection = DriverManager.getConnection(urlDB, userDB, passwordDB);

    } catch (Exception e) {
      System.out.println("Error, couldn't install Connection :(((((");
    }
//    finally {
//      if (connection != null) {
//        try {
//          connection.close();
//        } catch (SQLException e) {
//          System.out.println("SQL error.");
//        }
//      }
//    }
  }

  static {
    instance = new ConnectionFactory();
  }

  public static ConnectionFactory getInstance() {
    return instance;
  }

  public Connection getConnection() throws SQLException {
    System.out.println("Connection return");
    return connection;
  }

  public PreparedStatement getStatement() {
    return statement;
  }
}