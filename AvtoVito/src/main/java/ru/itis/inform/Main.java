package ru.itis.inform;

import ru.itis.inform.dao.AutoDAOImpl;
import ru.itis.inform.dao.UserDAOImpl;
import ru.itis.inform.models.Auto;
import ru.itis.inform.models.User;
import ru.itis.inform.services.UserServiceImpl;

import java.sql.SQLException;

/**
 * Created by farkh on 24/10/2016.
 */
public class Main {
  public static void main(String[] args) throws SQLException {

    UserDAOImpl userDAO = new UserDAOImpl();
//    AutoDAOImpl autoDAO = new AutoDAOImpl();
//    userDAO.save(new User("user1", "12", "name surname", "blabla, 7", "79179179402"));
//    this.brand = brand;
//    this.type = type;
//    this.mileage = mileage;
//    this.horsepower = horsepower;
//    this.gearbox = gearbox;
//    this.year = year;
//    this.color = color;
//    this.wheel = wheel;
//    this.price = price;
//    Auto auto = new Auto("BMW", "new", "100000", "200", "auto", "2001", "red", "right", "100000");
//    autoDAO.save(auto);

    UserServiceImpl userService = new UserServiceImpl();

    User user = userService.findUser("user1");
    System.out.println(user.getPassword());
  }
}
