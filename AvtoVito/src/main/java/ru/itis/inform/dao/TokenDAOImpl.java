package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenDAOImpl implements TokenDAO {

  private String query;

  public void addToken(String id, String token) {

    try {

      if (ConnectionFactory.getInstance().getConnection() != null && id != "" && token != "") {

        query = "INSERT INTO Cookies (id, token) VALUES ( ? , ? );";

        sqlUpdate(id, token, query);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateToken(String id, String token) {

    try {

      if (ConnectionFactory.getInstance().getConnection() != null && id != "" && token != "") {

        query = "UPDATE Cookies SET (token) = ( ? ) WHERE id = ? ";
        sqlUpdate(token, id, query);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteToken(String token) {

    try {

      if (ConnectionFactory.getInstance().getConnection() != null && token != "") {

        query = "DELETE FROM Cookies WHERE token = ?";

        ConnectionFactory.statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
        ConnectionFactory.statement.setString(1, token);
        ConnectionFactory.statement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public String findToken(String token) {

    try {

      if (ConnectionFactory.getInstance().getConnection() != null && token != "") {

        query = "SELECT * FROM Cookies WHERE token = ?";

        ConnectionFactory.statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
        ConnectionFactory.statement.setString(1, token);
        ResultSet resultSet = ConnectionFactory.getInstance().getStatement().executeQuery();

        return resultSet.getString("id");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  private void sqlUpdate(String first, String second, String query) {
    try {
      ConnectionFactory.statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
      ConnectionFactory.statement.setString(1, first);
      ConnectionFactory.statement.setString(2, second);
      ConnectionFactory.getInstance().getStatement().executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}