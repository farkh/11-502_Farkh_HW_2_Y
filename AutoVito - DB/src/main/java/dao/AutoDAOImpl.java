package dao;

import factories.ConnectionFactory;
import models.Auto;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AutoDAOImpl implements AutoDAO {

  private String query;

  public AutoDAOImpl() {
    this.query = "";
  }

  public List<Auto> find(String query) {
    List<Auto> list = null;
    Statement statement;

    this.query = query;

    try {

      ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
      statement = connectionFactory.getConnection().createStatement();

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        list.add(new Auto(resultSet.getInt("id"), resultSet.getString("brand"), resultSet.getString("type"), resultSet.getInt("price"), resultSet.getString("color"), resultSet.getString("wheel"), resultSet.getInt("mileage"), resultSet.getInt("horsepower"), resultSet.getString("gearbox"), resultSet.getInt("year")));
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }

    return list;
  }

  public void save(Auto auto) {
    query = "INSERT INTO Auto (id, brand, type, price, color, wheel, mileage, horsepower, gearbox, year) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {

      PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      statement.setInt(1, auto.getId());
      statement.setString(2, auto.getBrand());
      statement.setString(3, auto.getType());
      statement.setInt(4, auto.getPrice());
      statement.setString(5, auto.getColor());
      statement.setString(6, auto.getWheel());
      statement.setInt(7, auto.getMileage());
      statement.setInt(8, auto.getHorsepower());
      statement.setString(9, auto.getGearbox());
      statement.setInt(10, auto.getYear());

      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Auto> findAll() {
    return null;
  }
}
