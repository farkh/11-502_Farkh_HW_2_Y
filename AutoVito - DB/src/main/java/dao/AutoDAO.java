package dao;

import models.Auto;
import models.Requirement;

import java.sql.SQLException;
import java.util.List;

public interface AutoDAO {
  List<Auto> find(String query);
  void save(Auto auto);
  void saveRequirements(Requirement requirements);
  List<Auto> findAll();
}