package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.models.Auto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AutoDAOImpl implements AutoDAO {
  private String query;

  public Auto find() {
    return null;
  }

  public void save(Auto auto) {
    query = "INSERT INTO Auto (auto_id, brand, type, price, color, wheel, mileage, horsepower, gearbox, year) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    try {

      PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      statement.setString(1, "" + auto.getId());
      statement.setString(2, auto.getBrand());
      statement.setString(3, auto.getType());
      statement.setString(4, "" + auto.getPrice());
      statement.setString(5, auto.getColor());
      statement.setString(6, auto.getWheel());
      statement.setString(7, auto.getMileage());
      statement.setString(8, auto.getHorsepower());
      statement.setString(9, auto.getGearbox());
      statement.setString(10, auto.getYear());

      ConnectionFactory.statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void saveRequirements(String userId, Auto auto) {

    query = "INSERT INTO Requirements (id, brand, type, mileage, horsepower, gearbox, year, color, wheel ) VALUES (" + userId + " ? , ? , ? , ? , ? , ? , ? , ? );";

    try {

      PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

      statement.setString(1, auto.getBrand());
      statement.setString(2, auto.getType());
      statement.setString(3, auto.getMileage());
      statement.setString(4, auto.getHorsepower());
      statement.setString(5, auto.getGearbox());
      statement.setString(6, auto.getYear());
      statement.setString(7, auto.getColor());
      statement.setString(8, auto.getWheel());

      ConnectionFactory.statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Auto> findAll() {
    return null;
  }
}