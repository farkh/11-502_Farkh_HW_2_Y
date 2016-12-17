package dao;

import models.Customer;
import factories.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

  private String query;

  public CustomerDAOImpl() {
    this.query = "";
  }

  public Customer find(String login) {

    Statement statement;
    Customer resCustomer = null;
    try {

      String checkLogin;
      query = "SELECT * FROM customers;";

      ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
      statement = connectionFactory.getConnection().createStatement();

      ResultSet resultSet = statement.executeQuery(query);

      while (resultSet.next()) {
        checkLogin = resultSet.getString("login");
        if (login.equals(checkLogin)) {
          resCustomer = new Customer(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("city"), resultSet.getString("street"), resultSet.getString("house"), resultSet.getString("phone"));
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Error, find() doesn't work :(");
    }

    return resCustomer;
  }

  public void save(Customer customer) throws SQLException {
    query = "INSERT INTO Customers (id, login, password, name, surname, city, street, house, phone) VALUES ( ? , ? , ? , ? , ? , ?, ?, ?, ?);";

    PreparedStatement statement = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

    statement.setInt(1, customer.getId());
    statement.setString(2, customer.getLogin());
    statement.setString(3, customer.getPassword());
    statement.setString(4, customer.getName());
    statement.setString(5, customer.getSurname());
    statement.setString(6, customer.getCity());
    statement.setString(7, customer.getStreet());
    statement.setString(8, customer.getHouse());
    statement.setString(9, customer.getPhone());
  }

  public List<Customer> findAll() {
    return null;
  }
}
