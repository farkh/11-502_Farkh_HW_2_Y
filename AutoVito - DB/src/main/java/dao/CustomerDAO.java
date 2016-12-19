package dao;

import models.Customer;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
  void save(Customer customer) throws SQLException;
  List<Customer> findAll();
}