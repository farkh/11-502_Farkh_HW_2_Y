package ru.itis.inform.dao;

import java.sql.SQLException;
import java.util.LinkedList;

public interface AutoDAO {
  public LinkedList<Auto> findAll() throws SQLException;
  public void save(Auto auto) throws SQLException;
}
