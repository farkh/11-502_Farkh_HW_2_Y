package ru.itis.inform.dao;

import java.sql.SQLException;
import java.util.LinkedList;

public interface UserDAO {
  public LinkedList<User> findAll() throws SQLException;
  public void save(User user) throws SQLException;
}