package dao;

import factories.ConnectionFactory;
import models.Auto;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AutoDAOImpl implements AutoDAO {

  private String query;

  public AutoDAOImpl() {
    this.query = "";
  }

  public List<Auto> find(String query) {
    List<Auto> list = new LinkedList<Auto>();
    Statement statement;

    this.query = query;
    System.out.println(query);

    try {

      statement = ConnectionFactory.getInstance().getConnection().createStatement();

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        Auto auto = new Auto(resultSet.getInt("auto_id"), resultSet.getString("brand"), resultSet.getString("type"), resultSet.getInt("price"), resultSet.getString("color"), resultSet.getString("wheel"), resultSet.getInt("mileage"), resultSet.getInt("horsepower"), resultSet.getString("gearbox"), resultSet.getInt("year"), resultSet.getString("image_link"));
        list.add(auto);
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }


    return list;
  }

  public void save(Auto auto) {
    query = "INSERT INTO Auto VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {

      PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      statement.setString(1, auto.getBrand());
      statement.setString(2, auto.getType());
      statement.setInt(3, auto.getPrice());
      statement.setString(4, auto.getColor());
      statement.setString(5, auto.getWheel());
      statement.setInt(6, auto.getMileage());
      statement.setInt(7, auto.getHorsepower());
      statement.setString(8, auto.getGearbox());
      statement.setInt(9, auto.getYear());
      statement.setString(10, auto.getImageLink());

      statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
