package ru.itis.inform.filters;

import ru.itis.inform.dao.UserDAO;
import ru.itis.inform.factories.DAOFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInFilter implements Filter {

  public void init (FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if (((HttpServletRequest) servletRequest).getSession().getAttribute("current_user") != null) {
      servletRequest.getRequestDispatcher("/auto").forward(servletRequest, servletResponse);
    } else {
      UserDAO userDAO = DAOFactory.getInstance().getUserDAO();

      String userName;
      String token = null;

      Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();

      for (Cookie cookie : cookies) {
        if ("autoVitoCookie".equals(cookie.getName())) {
          token = cookie.getValue();
        }
      }

      if (token != null) {
        userName = userDAO.isExists(token);
        System.out.println(userName);
        ((HttpServletRequest) servletRequest).getSession().setAttribute("current_user", userName);
        ((HttpServletResponse) servletResponse).sendRedirect("/auto");
      } else {
        filterChain.doFilter(servletRequest, servletResponse);
      }
    }
  }

  public void destroy() {

  }
}