package ru.itis.inform.servlets;

import ru.itis.inform.dao.UserDAOImpl;
import ru.itis.inform.models.User;
import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.TokenServiceImpl;
import ru.itis.inform.services.UserService;
import ru.itis.inform.services.UserServiceImpl;
import ru.itis.inform.utils.Token;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
  TokenService tokenService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();

    String user = (String) session.getAttribute("current_user");

    if (user != null) {
      resp.sendRedirect("/auto");
    } else {
      RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.jsp");
      requestDispatcher.forward(req, resp);
    }
  }
  // End of doGet()

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");

    String login = req.getParameter("login-signin-field");
    String password = req.getParameter("password-signin-field");
//    String cookieCheck = req.getParameter("cookie");
    UserServiceImpl userService = new UserServiceImpl();

    User currentUser = userService.findUser(login);

    if (currentUser != null) {
      if (password.equals(currentUser.getPassword())) {
        HttpSession session = req.getSession();

        // S E S S I O N
        session.setAttribute("current_user", currentUser);
        //cookieCheck != null && cookieCheck.equals("true")
        if (true) {

          String token = Token.getToken();
          Cookie cookie = new Cookie("current_user", token);
          cookie.setMaxAge(7 * 24 * 60 * 60);
          resp.addCookie(cookie);
          tokenService = new TokenServiceImpl();
          tokenService.addToken("" + currentUser.getId(), token);
        }
        resp.sendRedirect("/auto");
      } else {
        resp.sendRedirect("/notfound");
      }
    }

  }
  // End of doPost()
}