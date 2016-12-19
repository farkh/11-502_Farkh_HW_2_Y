package servlets;

import models.User;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    Object user = session.getAttribute("current_user");

    if (user != null) {
      resp.sendRedirect("/autos");
    } else {
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
      requestDispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");


    String login = req.getParameter("login");
    String password = req.getParameter("password");

    UserServiceImpl userService = new UserServiceImpl();

    User currentUser = userService.findUser(login);

    if (currentUser != null) {
      if (password.equals(currentUser.getPassword())) {
        HttpSession session = req.getSession();

        // S E S S I O N
        session.setAttribute("current_user", currentUser);
        resp.sendRedirect("/autos");
      } else {
        resp.sendRedirect("/notfound");
      }
    } else {
      resp.sendRedirect("/notfound");
    }

  }
}
