<%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 13/10/2016
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Регистрация - AutoVito</title>

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
    <h2>Регистрация</h2>
    <hr>
    <form role="form" method="POST">
      <h4>Данные пользователя</h4>
      <br>
      <div class="form-group">
        <label for="username-join-field">Имя пользователя</label>
        <input name="username-register-field" type="text" class="form-control" id="username-join-field" placeholder="Введите логин" required>
      </div>
      <div class="form-group">
        <label for="password-join-field">Пароль</label>
        <input name="password-register-field" type="password" class="form-control" id="password-join-field" placeholder="Пароль" required>
      </div>
      <div class="form-group">
        <label for="name-join-field">ФИО</label>
        <input name="fio-register-field" type="text" class="form-control" id="name-join-field" placeholder="ФИО">
      </div>
      <div class="form-group">
        <label for="address-join-field">Адрес</label>
        <input name="address-register-field" type="text" class="form-control" id="address-join-field" placeholder="Город, улица, дом">
      </div>
      <div class="form-group">
        <label for="phone-join-field">Телефон</label>
        <input name="phone-register-field" type="text" class="form-control" id="phone-join-field" placeholder="+7 (XXX) XXX-XX-XX">
      </div>
      <hr>
      <h4>Характеристики авто</h4>
      <br>
      <div class="form-group">
        <label for="brand-join-select">Какие бренды предпочитаете?</label>
        <select name="brand-register-field" multiple class="form-control" id="brand-join-select">
          <option value="audi">Audi</option>
          <option value="bmw">BMW</option>
          <option value="bentley">Bentley</option>
          <option value="bugatti">Bugatti</option>
          <option value="chevrolet">Chevrolet</option>
          <option value="daewoo">Daewoo</option>
          <option value="dodge">Dodge</option>
          <option value="fiat">Fiat</option>
          <option value="ford">Ford</option>
          <option value="honda">Honda</option>
          <option value="hyundai">Hyundai</option>
          <option value="infinity">Infiniti</option>
          <option value="jaguar">Jaguar</option>
          <option value="jeep">Jeep</option>
          <option value="kia">Kia</option>
          <option value="lada">Lada</option>
          <option value="lexus">Lexus</option>
          <option value="mazda">Mazda</option>
          <option value="mercedes">Mercedes-Benz</option>
          <option value="mitsubishi">Mitsubishi</option>
          <option value="nissan">Nissan</option>
          <option value="opel">Opel</option>
          <option value="porsche">Porsche</option>
          <option value="renault">Renault</option>
          <option value="skoda">Skoda</option>
          <option value="subaru">Subaru</option>
          <option value="toyota">Toyota</option>
          <option value="volkswagen">Volkswagen</option>
          <option value="volvo">Volvo</option>
        </select>
      </div>
      <div class="form-group">
        <label for="type-join-field">Тип авто</label>
        <select name="type-register-field" id="type-join-field" class="form-control">
          <option value="new">Новые</option>
          <option value="old">С пробегом</option>
        </select>
      </div>
      <div class="form-group">
        <label for="mileage-join-field">Пробег</label>
        <input name="mileage-register-field" type="text" class="form-control" id="mileage-join-field" placeholder="Пробег в км">
      </div>
      <div class="form-group">
        <label for="horsepower-join-field">Мощность</label>
        <input name="horsepower-register-field" type="text" class="form-control" id="horsepower-join-field" placeholder="Мощность в л.с.">
      </div>
      <div class="form-group">
        <label for="gearbox-join-field">Коробка передач</label>
        <select name="gearbox-register-field" id="gearbox-join-field" class="form-control">
          <option value="auto">Автоматическая</option>
          <option value="mech">Механическая</option>
        </select>
      </div>
      <div class="form-group">
        <label for="year-join-field">Год выпуска</label>
        <input name="year-register-field" type="text" class="form-control" id="year-join-field" placeholder="yyyy">
      </div>
      <div class="form-group">
        <label for="color-join-select">Цвет</label>
        <select name="color-register-field" class="form-control" id="color-join-select">
          <option value="white">Белый</option>
          <option value="black">Черный</option>
          <option value="red">Красный</option>
          <option value="yellow">Желтый</option>
          <option value="grey">Серый</option>
          <option value="blue">Синий</option>
          <option value="green">Зеленый</option>
        </select>
      </div>
      <div class="form-group">
        <label for="wheel-join-field">Руль</label>
        <select name="wheel-register-field" id="wheel-join-field" class="form-control">
          <option value="left">Левый</option>
          <option value="right">Правый</option>
        </select>
      </div>
      <div class="form-group">
        <label for="price-join-field">Цена</label>
        <input name="price-register-field" type="text" class="form-control" id="price-join-field" placeholder="Цена в руб.">
      </div>

      <br>
      <button type="submit" class="btn btn-primary btn-block">Регистрация</button>
      <br>
      <hr>
      <a href="/login">Уже есть аккаунт?</a>
    </form>
  </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js" type="text/JavaScript"></script>
<script src="js/phone.js" type="text/JavaScript"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $("#phone-join-field").mask("+7 (999)-999-99-99");
    $("#year-join-field").mask("9999", { placeholder: "yyyy" });
  });
</script>
</body>
</html>