package servlets;

import dao.AutoDAOImpl;
import models.Auto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher=req.getRequestDispatcher("/add.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Auto auto;
    AutoDAOImpl autoDAO = new AutoDAOImpl();

    auto = new Auto(
            1,
            req.getParameter("brand"),
            req.getParameter("type"),
            Integer.valueOf(req.getParameter("price")),
            req.getParameter("color"),
            req.getParameter("wheel"),
            Integer.valueOf(req.getParameter("mileage")),
            Integer.valueOf(req.getParameter("horsepower")),
            req.getParameter("gearbox"),
            Integer.valueOf(req.getParameter("year")),
            req.getParameter("image")
    );

    autoDAO.save(auto);
    resp.sendRedirect("/autos");
  }
}
