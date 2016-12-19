package servlets;


import dao.CustomerDAOImpl;
import dao.UserDAOImpl;
import models.Customer;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    Object user = session.getAttribute("current_user");

    if (user != null) {
      resp.sendRedirect("/autos");
    } else {
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signup.jsp");
      requestDispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");

    Customer customer;
    User user;
    UserDAOImpl userDAO = new UserDAOImpl();
    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    user = new User(
            req.getParameter("login"),
            req.getParameter("password")
    );

    customer = new Customer(
            req.getParameter("name"),
            req.getParameter("surname"),
            req.getParameter("city"),
            req.getParameter("street"),
            req.getParameter("house"),
            req.getParameter("phone")
    );

    if (user.getLogin() != null & user.getPassword() != null) {
      try {
        userDAO.save(user);
        customerDAO.save(customer);
      } catch (SQLException e) {
        e.printStackTrace();
      }

      resp.sendRedirect("/login");
    } else {
      resp.sendRedirect("/signup");
    }
  }
}
