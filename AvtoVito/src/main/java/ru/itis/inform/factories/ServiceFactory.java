package ru.itis.inform.factories;

import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.UserService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ServiceFactory {
  private static ServiceFactory instance;
  private Properties properties;
  private UserService userService;
  private TokenService tokenService;

  private ServiceFactory() {
    properties = new Properties();

    try {
      properties.load(new FileInputStream("/Users/farkh/Programming/11-502_Farkh_HW_2_Y/AvtoVito/src/main/resources/service.properties"));

      //UserService
      this.userService = (UserService) Class.forName(properties.getProperty("userService.class")).newInstance();
      //TokenService
      this.tokenService = (TokenService) Class.forName(properties.getProperty("tokenService.class")).newInstance();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  static {
    instance = new ServiceFactory();
  }

  public static ServiceFactory getInstance() {
    return instance;
  }

  public UserService getUserService() {
    return userService;
  }

  public TokenService getTokenService() {
    return tokenService;
  }
}