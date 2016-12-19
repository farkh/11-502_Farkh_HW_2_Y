<%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 18/12/2016
  Time: 02:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Log in</title>

  <!-- Semantic UI -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.6/semantic.min.css">
</head>
<body>
  <div class="ui fixed top menu">
    <a class="item" href="/">AutoVito</a>
    <a class="item" href="/autos">Autos</a>
    <div class="right menu">
      <div class="item">
        <a class="ui primary button disabled" href="/login">Log in</a>
      </div>
      <div class="item">
        <a class="ui button" href="/signup">Sign up</a>
      </div>
    </div>
  </div>

  <br><br><br><br>
  <h2 class="ui center aligned icon header"><i class="circular users icon"></i>Log In</h2>

  <div class="ui middle aligned center aligned grid">
    <div class="five wide column">
      <form class="ui large form" method="POST">
        <div class="ui stacked segment">
          <div class="field">
            <div class="ui left icon input">
              <i class="user icon"></i>
              <input type="text" name="login" placeholder="Login">
            </div>
          </div>
          <div class="field">
            <div class="ui left icon input">
              <i class="lock icon"></i>
              <input type="password" name="password" placeholder="Password">
            </div>
          </div>
          <button class="ui fluid large teal submit button">Login</button>
        </div>
      </form>

      <div class="ui message">
        New to us? <a href="/signup">Sign Up</a>
      </div>
    </div>
  </div>

  <!-- Semantic UI -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.6/semantic.min.js"></script>
</body>
</body>
</html>
