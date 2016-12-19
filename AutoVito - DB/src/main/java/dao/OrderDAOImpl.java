package dao;

import factories.ConnectionFactory;
import models.Order;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {
  public void save(Order order) throws SQLException {
    String query = "SELECT order_ins(?, ?, ?);";

    PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

    statement.setInt(1, order.getAutoId());
    statement.setString(2, order.getLogin());
    statement.setString(3, order.getSupplierName());

    statement.executeQuery();
  }
}
