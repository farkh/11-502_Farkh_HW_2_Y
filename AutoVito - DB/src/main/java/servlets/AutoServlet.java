package servlets;

import dao.AutoDAOImpl;
import dao.OrderDAOImpl;
import models.Auto;
import models.Order;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AutoServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    int autoId = (Integer) session.getAttribute("auto_id");

    String query = "SELECT * FROM auto WHERE (auto_id=" + autoId + ");";
    AutoDAOImpl autoDAO = new AutoDAOImpl();
    List<Auto> list = autoDAO.find(query);

    session.setAttribute("autos", list);

    RequestDispatcher requestDispatcher=req.getRequestDispatcher("/auto.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    int autoId = Integer.valueOf(req.getParameter("id"));
    String login = ((User) session.getAttribute("current_user")).getLogin();
    String suppName = "Supplier";

    Order order = new Order(autoId, login, suppName);

    OrderDAOImpl orderDAO = new OrderDAOImpl();
    try {
      orderDAO.save(order);
      resp.sendRedirect("/");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
