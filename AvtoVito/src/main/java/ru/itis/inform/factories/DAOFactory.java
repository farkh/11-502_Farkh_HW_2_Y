package ru.itis.inform.factories;

import ru.itis.inform.dao.AutoDAO;
import ru.itis.inform.dao.UserDAO;
import ru.itis.inform.models.Auto;
import ru.itis.inform.models.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

  private static DAOFactory instance;
  private Properties properties;

  private UserDAO userDAO;
  private AutoDAO autoDAO;
  private String userDAOClass;
  private String autoDAOClass;

  private DAOFactory() {

    try {
      properties = new Properties();
      properties.load(new FileInputStream("/Users/farkh/Programming/11-502_Farkh_HW_2_Y/AvtoVito/src/main/resources/dao.properties"));

      Class userClass = Class.forName(properties.getProperty("userDAO.class"));
      Class autoClass = Class.forName(properties.getProperty("autoDAO.class"));

      Constructor userClassConstructor = userClass.getConstructor(Connection.class);
      Constructor autoClassConstructor = autoClass.getConstructor(Connection.class);

      this.userDAO = (UserDAO) userClassConstructor.newInstance(ConnectionFactory.getInstance().getConnection());
      this.autoDAO = (AutoDAO) autoClassConstructor.newInstance(ConnectionFactory.getInstance().getConnection());

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  static {
    instance = new DAOFactory();
  }

  public static DAOFactory getInstance() {
    return instance;
  }

  public UserDAO getUserDAO() {
    return userDAO;
  }

  public AutoDAO getAutoDAO() {
    return autoDAO;
  }
}