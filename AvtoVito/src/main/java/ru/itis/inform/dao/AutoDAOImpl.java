package ru.itis.inform.dao;

import ru.itis.inform.factories.ConnectionFactory;
import ru.itis.inform.models.Auto;

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

      Statement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
      ConnectionFactory.statement.setString(1, "" + auto.getId());
      ConnectionFactory.statement.setString(2, auto.getBrand());
      ConnectionFactory.statement.setString(3, auto.getType());
      ConnectionFactory.statement.setString(4, "" + auto.getPrice());
      ConnectionFactory.statement.setString(5, auto.getColor());
      ConnectionFactory.statement.setString(6, auto.getWheel());
      ConnectionFactory.statement.setString(7, auto.getMileage());
      ConnectionFactory.statement.setString(8, auto.getHorsepower());
      ConnectionFactory.statement.setString(9, auto.getGearbox());
      ConnectionFactory.statement.setString(10, auto.getYear());

      ConnectionFactory.statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void saveRequirements(String userId, Auto auto) {

    query = "INSERT INTO Requirements (id, brand, type, mileage, horsepower, gearbox, year, color, wheel ) VALUES (" + userId + " ? , ? , ? , ? , ? , ? , ? , ? );";

    try {

      Statement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);
      ConnectionFactory.statement.setString(1, auto.getBrand());
      ConnectionFactory.statement.setString(2, auto.getType());
      ConnectionFactory.statement.setString(3, auto.getMileage());
      ConnectionFactory.statement.setString(4, auto.getHorsepower());
      ConnectionFactory.statement.setString(5, auto.getGearbox());
      ConnectionFactory.statement.setString(6, auto.getYear());
      ConnectionFactory.statement.setString(7, auto.getColor());
      ConnectionFactory.statement.setString(8, auto.getWheel());

      ConnectionFactory.statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Auto> findAll() {
    return null;
  }
}