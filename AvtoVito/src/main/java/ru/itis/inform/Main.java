package ru.itis.inform;

import ru.itis.inform.dao.AutoDAO;
import ru.itis.inform.dao.AutoDAOImpl;
import ru.itis.inform.dao.UserDAOImpl;
import ru.itis.inform.factories.DAOFactory;
import ru.itis.inform.models.Auto;
import ru.itis.inform.models.User;
import ru.itis.inform.services.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by farkh on 24/10/2016.
 */
public class Main {
  public static void main(String[] args) throws SQLException {

    AutoDAO autoDAO = DAOFactory.getInstance().getAutoDAO();

    List<Auto> autos = autoDAO.findAll();
  }
}
