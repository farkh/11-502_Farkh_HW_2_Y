<%@ page import="models.Auto" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.AutoDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 18/12/2016
  Time: 03:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Autos - AutoVito</title>

  <!-- Semantic UI -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.6/semantic.min.css">
</head>
<body>
  <div class="ui fixed top menu">
    <a class="item" href="/">AutoVito</a>
    <a class="item active" href="/autos">Autos</a>
    <div class="right menu">
      <div class="item">
        <a class="ui primary button" href="/login">Log in</a>
      </div>
      <div class="item">
        <a class="ui button" href="/signup">Sign up</a>
      </div>
    </div>
  </div>

  <br><br><br><br>
  <div class="ui grid">
    <div class="two wide column"></div>
    <div class="twelve wide column">
      <h1>Autos</h1>
      <a href="/search" class="ui button">Search Auto</a>
      <a href="/add" class="ui blue button">Add Auto</a>
      <hr>
      <br>
      <%
        List<Auto> list = (List<Auto>) session.getAttribute("autos");
      %>
      <div class="ui grid">
        <% if (list.size() != 0) { %>
          <% for (Auto auto : list) { %>
            <div class="four wide column">
              <div class="ui link cards">
                <div class="card">
                  <div class="image">
                    <img src="<%= auto.getImageLink() %>">
                  </div>
                  <div class="content">
                    <div class="header"><%= auto.getBrand() %></div>
                    <div class="meta">
                      <a><%= auto.getYear() %></a>
                    </div>
                  </div>
                  <div class="extra content">
                    <form method="POST" action="/autos">
                      <input type="text" name="id" value="<%= auto.getId()%>" style="display: none;">
                      <button type="submit" href="/auto" class="ui button right floated">Info</button>
                    </form>
                    <form action="/autos" method="POST">
                      <input type="text" name="id" value="<%= auto.getId()%>" style="display: none;">
                      <button type="submit" href="autos" class="ui red button delete">Delete</button>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          <% } %>
        <% } else { %>
          <div class="sixteen wide column">
            <div class="ui yellow message">There are no cars.</div>
          </div>
        <% } %>
      </div>
    </div>
  </div>
  
  <!-- Semantic UI -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.6/semantic.min.js"></script>
</body>
</html>
