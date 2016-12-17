package ru.itis.inform.servlets;

import ru.itis.inform.dao.AutoDAO;
import ru.itis.inform.factories.DAOFactory;
import ru.itis.inform.models.Auto;
import ru.itis.inform.models.User;
import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.TokenServiceImpl;
import ru.itis.inform.services.UserServiceImpl;
import ru.itis.inform.utils.Hash;
import ru.itis.inform.utils.Token;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add.jsp");
    requestDispatcher.forward(req, resp);
  }
  // End of doGet()

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");

    String brand = req.getParameter("brand-add-field");
    String link = req.getParameter("link-add-field");
    String id = String.valueOf(Math.random() + 9);

    Auto auto = new Auto(id, brand, link);

    AutoDAO autoDAO = DAOFactory.getInstance().getAutoDAO();

    autoDAO.save(auto);
    resp.sendRedirect("/auto");
  }
  // End of doPost()
}