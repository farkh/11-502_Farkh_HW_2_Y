package servlets;

import dao.AutoDAOImpl;
import models.Auto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String query = "SELECT * FROM AllAutos;";
    AutoDAOImpl autoDAO = new AutoDAOImpl();
    List<Auto> list = autoDAO.find(query);

    session.setAttribute("autos", list);
    RequestDispatcher requestDispatcher=req.getRequestDispatcher("/main.jsp");
    requestDispatcher.forward(req,resp);
  }
}