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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher requestDispatcher=req.getRequestDispatcher("/search.jsp");
    requestDispatcher.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> parameters = new HashMap<String, String>();
    String[] arr = new String[] {"brand", "type", "price", "color", "wheel", "mileage", "horsepower", "gearbox", "year", "image_link"};

    for (int i = 0; i < arr.length; i++) {
      if (req.getParameter(arr[i]) != "" && req.getParameter(arr[i]) != null) {
        parameters.put(arr[i], req.getParameter(arr[i]));
      }
    }



    String query = "SELECT * FROM auto WHERE (";

    for (Map.Entry entry : parameters.entrySet()) {
      query += (entry.getKey() + "='" + firstUpperCase("" + entry.getValue()) + "', ");
    }

    query = query.substring(0, query.length() - 2) + ");";

    System.out.println("QUERY:" + query);

    HttpSession httpSession = req.getSession();
    AutoDAOImpl autoDAO = new AutoDAOImpl();
    List<Auto> list = autoDAO.find(query);
    httpSession.setAttribute("autos", list);

    resp.sendRedirect("/autos");
  }

  public String firstUpperCase(String word){
    if(word == null) return word;
    return word.substring(0, 1).toUpperCase() + word.substring(1);
  }
}
