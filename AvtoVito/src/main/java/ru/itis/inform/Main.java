package ru.itis.inform;

import ru.itis.inform.dao.UserDAOImpl;
import ru.itis.inform.models.User;

/**
 * Created by farkh on 24/10/2016.
 */
public class Main {
  public static void main(String[] args) {

    UserDAOImpl userDAO = new UserDAOImpl();
    userDAO.save(new User("login", "password", "fio", "address", "phone"));
  }
}
