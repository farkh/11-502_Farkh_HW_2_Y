package ru.itis.inform.services;

import ru.itis.inform.dao.TokenDAO;
import ru.itis.inform.dao.TokenDAOImpl;

public class TokenServiceImpl implements TokenService {

  TokenDAO tokenDAO;

  public TokenServiceImpl() {
    tokenDAO = new TokenDAOImpl();
  }

  public void addToken(String id, String token) {
    tokenDAO.addToken(id, token);
  }

  public void updateToken(String id, String token) {
    tokenDAO.updateToken(id, token);
  }

  public void deleteToken(String token) {
    tokenDAO.deleteToken(token);
  }

  public String findToken(String token) {
    return tokenDAO.findToken(token);
  }
}