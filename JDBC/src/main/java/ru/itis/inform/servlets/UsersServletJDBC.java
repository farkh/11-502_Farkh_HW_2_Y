package ru.itis.inform.servlets;

import ru.itis.inform.dao.UserDAOImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UsersServletJDBC extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserDAOImpl usersDAO = new UserDAOImpl();
    try {
      request.setAttribute("userlist", usersDAO.findAll());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
  }
}