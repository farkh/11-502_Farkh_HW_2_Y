package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.models.Auto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class AutoDAOImpl implements AutoDAO {
  private String query;

  public AutoDAOImpl() {
    query = "";
  }

  public Auto find() {
    return null;
  }

  public void save(Auto auto) {

    query = "INSERT INTO auto (id, brand, photo_link) VALUES ( ? , ? , ?);";

    PreparedStatement statement = null;
    try {
      statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      statement.setString(1, auto.getId());
      statement.setString(2, auto.getBrand());
      statement.setString(3, auto.getPhotoLink());

      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Auto> findAll() {

    List<Auto> list = new LinkedList<Auto>();
    query = "SELECT * FROM auto";

    try {
      PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        list.add(new Auto(resultSet.getString("brand"), resultSet.getString("photo_link")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }
}