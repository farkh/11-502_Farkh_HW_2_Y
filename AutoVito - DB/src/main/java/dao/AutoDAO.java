package dao;

import models.Auto;

import java.util.List;

public interface AutoDAO {
  List<Auto> find(String query);
  void save(Auto auto);
  List<Auto> findAll();
}