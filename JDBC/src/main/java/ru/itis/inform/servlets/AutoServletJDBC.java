package ru.itis.inform.servlets;

import ru.itis.inform.dao.AutoDAOImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AutoServletJDBC extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    AutoDAOImpl autoDAO= new AutoDAOImpl();
    try {
      request.setAttribute("autolist", autoDAO.findAll());
    } catch (SQLException e) {
      e.printStackTrace();
    }

    getServletContext().getRequestDispatcher("/auto.jsp").forward(request, response);
  }
}
