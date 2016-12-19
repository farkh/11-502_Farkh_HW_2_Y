package dao;

import models.Order;

import java.sql.SQLException;

public interface OrderDAO {
  void save(Order order) throws SQLException;
}
