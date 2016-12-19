<%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 18/12/2016
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Search Auto - AutoVito</title>

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
  <h2 class="ui center aligned icon header"><i class="car icon"></i>Search Auto</h2>

  <div class="ui middle aligned center aligned grid">
    <div class="five wide column">
      <form class="ui large form" method="POST">
        <div class="ui stacked segment">
          
          <div class="field">
            <div class="ui left icon input">
              <i class="car icon"></i>
              <input id="brand" type="text" name="brand" placeholder="Brand: Chevrolet Camaro SS">
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <select id="type" class="ui dropdown" name="type">
                <option value="">Type</option>
                <option value="new">New</option>
                <option value="manual">With Mileage</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="ruble icon"></i>
              <input id="price" type="text" name="price" placeholder="Price, in rubles">
            </div>
          </div>
          
          <div class="field">
            <div class="ui left icon input">
              <select id="color" class="ui dropdown" name="color">
                <option value="">Color</option>
                <option value="red">Red</option>
                <option value="black">Black</option>
                <option value="white">White</option>
                <option value="grey">Grey</option>
                <option value="blue">Blue</option>
                <option value="yellow">Yellow</option>
                <option value="green">Green</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <select id="wheel" class="ui dropdown" name="wheel">
                <option value="">Wheel</option>
                <option value="right">Right</option>
                <option value="left">Left</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="road icon"></i>
              <input id="mileage" type="text" name="mileage" placeholder="Mileage, in km">
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="space shuttle icon"></i>
              <input id="horsepower" type="text" name="horsepower" placeholder="Horsepower">
            </div>
          </div>
          
          <div class="field">
            <div class="ui left icon input">
              <select id="gearbox" class="ui dropdown" name="gearbox">
                <option value="">Gearbox</option>
                <option value="automatic">Automatic Gearbox</option>
                <option value="manual">Manual Gearbox</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="calendar icon"></i>
              <input id="year" type="text" name="year" placeholder="Year">
            </div>
          </div>

          <button id="search-button" class="ui fluid large teal submit button">Search Auto</button>
        </div>
      </form>

      <div class="ui message">
        Want to go back? <a href="/autos">Autos</a>
      </div>
    </div>
  </div>

  <!-- Semantic UI -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.6/semantic.min.js"></script>
</body>
</html>
