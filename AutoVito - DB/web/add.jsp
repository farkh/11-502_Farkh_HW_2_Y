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
  <title>Add Auto - AutoVito</title>

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
  <h2 class="ui center aligned icon header"><i class="car icon"></i>Add Auto</h2>

  <div class="ui middle aligned center aligned grid">
    <div class="five wide column">
      <form class="ui large form" method="POST">
        <div class="ui stacked segment">
          
          <div class="field">
            <div class="ui left icon input">
              <i class="car icon"></i>
              <input type="text" name="brand" placeholder="Brand: Chevrolet Camaro SS">
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <select class="ui dropdown" name="type">
                <option value="">Type</option>
                <option value="New">New</option>
                <option value="With mileage">With Mileage</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="ruble icon"></i>
              <input type="text" name="price" placeholder="Price, in rubles">
            </div>
          </div>
          
          <div class="field">
            <div class="ui left icon input">
              <select class="ui dropdown" name="color">
                <option value="">Color</option>
                <option value="Red">Red</option>
                <option value="Black">Black</option>
                <option value="White">White</option>
                <option value="Grey">Grey</option>
                <option value="Blue">Blue</option>
                <option value="Yellow">Yellow</option>
                <option value="Green">Green</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <select class="ui dropdown" name="wheel">
                <option value="">Wheel</option>
                <option value="Right">Right</option>
                <option value="Left">Left</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="road icon"></i>
              <input type="text" name="mileage" placeholder="Mileage, in km">
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="space shuttle icon"></i>
              <input type="text" name="horsepower" placeholder="Horsepower">
            </div>
          </div>
          
          <div class="field">
            <div class="ui left icon input">
              <select class="ui dropdown" name="gearbox">
                <option value="">Gearbox</option>
                <option value="Automatic">Automatic Gearbox</option>
                <option value="Manual">Manual Gearbox</option>
              </select>
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="calendar icon"></i>
              <input type="text" name="year" placeholder="Year">
            </div>
          </div>

          <div class="field">
            <div class="ui left icon input">
              <i class="linkify icon"></i>
              <input type="text" name="image" value="" placeholder="Link to photo: https://example.com/example.jpeg">
            </div>
          </div>

          <button class="ui fluid large teal submit button">Add Auto</button>
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
