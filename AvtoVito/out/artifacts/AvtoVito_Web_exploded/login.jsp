<%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 13/10/2016
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Войти - AutoVito</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- main.css -->
  <link rel="stylesheet" href="css/main.css">
  <link rel="icon" type="image/png" href="img/favicon.png">
</head>
<body>

<div class="container">
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

        <a href="/" class="navbar-brand">AutoVito</a>
      </div>

      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li><a href="/">Главная<span class="sr-only"></span></a></li>
          <li class="active"><a href="#join" class="btn-join-forjquery">Присоединиться</a></li>
          <li><a href="/auto">Автомобили</a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>

<div class="container-fluid join-form">
  <div class="col-lg-4 col-lg-offset-4">
    <h2>Войти</h2>
    <hr>
    <form role="form" method="post">
      <div class="form-group">
        <label for="username-login-field">Имя пользователя</label>
        <input name="login-signin-field" type="text" class="form-control" id="username-login-field" placeholder="Введите логин">
      </div>
      <div class="form-group">
        <label for="password-login-field">Пароль</label>
        <input name="password-signin-field" type="password" class="form-control" id="password-login-field" placeholder="Пароль">
      </div>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="checkbox-cookies"> Запомнить
        </label>
      </div>
      <br>
      <button type="submit" class="btn btn-primary btn-block">Войти</button>
      <br>
      <hr>
      <a href="/register">Еще нет аккаунта?</a>
    </form>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>