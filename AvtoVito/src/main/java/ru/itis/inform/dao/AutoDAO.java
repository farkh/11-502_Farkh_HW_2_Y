package ru.itis.inform.dao;

import ru.itis.inform.models.Auto;
import java.util.List;

public interface AutoDAO {
  Auto find();
  void save(Auto auto);
  void saveRequirements(String userId, Auto auto);
  List<Auto> findAll();
}