package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.factories.DAOFactory;
import ru.itis.inform.models.User;
import ru.itis.inform.utils.Hash;

import java.sql.*;
import java.util.List;

public class UserDAOImpl implements UserDAO {
  private String query;

  public UserDAOImpl(){}

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

    Hash hash = new Hash();

    query = "INSERT INTO customers (id, login, password, fio, address, phone) VALUES ( ? , ? , ? , ? , ? , ?);";

    PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);


    statement.setInt(1, user.getId());
    statement.setString(2, user.getLogin());
    statement.setString(3,  hash.generateHash(user.getPassword()));
    statement.setString(4, user.getFIO());
    statement.setString(5, user.getAddress());
    statement.setString(6, user.getPhone());

    statement.executeUpdate();
  }

  public List<User> findAll() {
    return null;
  }

  public String isExists (String token) {

    String userName = null;
    TokenDAO tokenDAO = DAOFactory.getInstance().getTokenDAO();

    String userID = tokenDAO.findToken(token);
    userName = findByID(userID);

    return userName;
  }

  public String findByID (String id) {

    String userName = null;
    PreparedStatement statement = null;
    try {
      statement = ConnectionFactory.getInstance().getConnection().prepareStatement(
              "SELECT login FROM \"Customers\" WHERE id = ?;"
      );

      statement.setString(1, id);

      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        userName = resultSet.getString("login");
      }



    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userName;
  }
}
