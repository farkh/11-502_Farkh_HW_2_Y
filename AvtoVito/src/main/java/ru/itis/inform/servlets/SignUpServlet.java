package ru.itis.inform.servlets;

import ru.itis.inform.dao.UserDAOImpl;
import ru.itis.inform.models.User;
import ru.itis.inform.services.UserServiceImpl;

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
      resp.sendRedirect("/auto");
    } else {
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register.jsp");
      requestDispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");

    UserServiceImpl userService = new UserServiceImpl();
    User user;
    UserDAOImpl userDAO = new UserDAOImpl();

    user = new User(
            req.getParameter("username-register-field"), //required
            req.getParameter("password-register-field"), //required
            req.getParameter("fio-register-field"),
            req.getParameter("address-register-field"),
            req.getParameter("phone-register-field")
    );

    if (user.getLogin() != null & user.getPassword() != null) {
      if (userService.findUser(user.getLogin()) != null) {
        resp.sendRedirect("/exists");
      } else {
        try {
          userDAO.save(user);
        } catch (SQLException e) {
          e.printStackTrace();
        }

        resp.sendRedirect("/login");
      }

    } else {
      resp.sendRedirect("/notfound");
      // VALIDATION HERE
    }
  }
}