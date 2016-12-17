package ru.itis.inform.servlets;

import ru.itis.inform.dao.AutoDAO;
import ru.itis.inform.dao.UserDAOImpl;
import ru.itis.inform.factories.DAOFactory;
import ru.itis.inform.models.Auto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AutoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AutoDAO autoDAO = DAOFactory.getInstance().getAutoDAO();
    List<Auto> autos = autoDAO.findAll();
    RequestDispatcher requestDispatcher=req.getRequestDispatcher("/auto.jsp");
    req.setAttribute("autos", autos);
    requestDispatcher.forward(req,resp);
  }
}