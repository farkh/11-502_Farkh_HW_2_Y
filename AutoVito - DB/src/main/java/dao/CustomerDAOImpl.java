package dao;

import models.Customer;
import factories.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

  private String query;

  public CustomerDAOImpl() {
    this.query = "";
  }

  public void save(Customer customer) throws SQLException {
    query = "INSERT INTO customers (name, surname, city, street, house, phone) VALUES (?, ?, ?, ?, ?, ?)";

    PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

    statement.setString(1, customer.getName());
    statement.setString(2, customer.getSurname());
    statement.setString(3, customer.getCity());
    statement.setString(4, customer.getStreet());
    statement.setString(5, customer.getHouse());
    statement.setString(6, customer.getPhone());

    statement.executeUpdate();
  }

  public List<Customer> findAll() {
    return null;
  }
}
