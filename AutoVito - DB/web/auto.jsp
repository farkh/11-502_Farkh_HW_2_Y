<%@ page import="models.Auto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 18/12/2016
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Auto - AutoVito</title>

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

  <%
    List<Auto> list = (List<Auto>) session.getAttribute("autos");
    Auto auto = list.get(0);
  %>

  <br><br><br><br>
  <div class="ui grid">
    <div class="three wide column"></div>
    <div class="ten wide column">
      <div class="ui raised fluid card">
        <div class="image">
          <img src="<%= auto.getImageLink() %>">
        </div>

        <div class="content">
          <div class="header" style="font-size: 2em;"><%= auto.getBrand() %></div>
          <div class="meta">
            <span class="category" style="font-size: 1.4em;"><%= auto.getYear() %></span>
          </div>
          <hr>
          <div class="description">
            
            <div class="ui list">
              <div class="item">
                <i class="warning sign icon"></i>
                <div class="content"><strong>Type: </strong><%= auto.getType()%></div>
              </div>
              <br>
              <div class="item">
                <i class="settings icon"></i>
                <div class="content"><strong>Gearbox: </strong><%= auto.getGearbox()%></div>
              </div>
              <br>
              <div class="item">
                <i class="space shuttle icon"></i>
                <div class="content"><strong>Horsepower: </strong><%= auto.getHorsepower()%></div>
              </div>
              <br>
              <div class="item">
                <i class="road icon"></i>
                <div class="content"><strong>Mileage: </strong><%= auto.getMileage()%></div>
              </div>
              <br>
              <div class="item">
                <i class="angle double left icon"></i>
                <div class="content"><strong>Wheel: </strong><%= auto.getWheel()%></div>
              </div>
              <br>
              <div class="item">
                <i class="wizard icon"></i>
                <div class="content"><strong>Color: </strong><a class="ui <%=auto.getColor()%> tag label"><%= auto.getColor()%></a></div>
              </div>
              <br>
              <div class="item">
                <i class="ruble icon"></i>
                <div class="content"><strong>Price: </strong><a class="ui tag label"><%= auto.getPrice()%>₽</a></div>
              </div>
            </div>
          </div>
        </div>
        <form action="/auto" method="POST">
          <input type="text" name="id" style="display: none;" value="<%= auto.getId()%>">
          <button type="submit" class="ui bottom attached button"><i class="add icon"></i>Buy this car</button>
        </form>
      </div>
      <br><br>

    </div>
  </div>
  
  <!-- Semantic UI -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.6/semantic.min.js"></script>
</body>
</html>
