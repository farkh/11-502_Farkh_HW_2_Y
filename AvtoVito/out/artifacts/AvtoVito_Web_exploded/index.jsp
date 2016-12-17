<%--
  Created by IntelliJ IDEA.
  User: farkh
  Date: 13/10/2016
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AutoVito</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- main.css -->
    <link rel="stylesheet" href="css/main.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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

                <a href="" class="navbar-brand">AutoVito</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#Top">Главная<span class="sr-only"></span></a></li>
                    <li><a href="/register">Присоединиться</a></li>
                    <!-- <li><a href="/auto">Автомобили</a></li> -->
                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="container-fluid col-lg-12 col-md-12 col-sm-12 banner">
    <div class="jumbotron">
        <div class="slogan">
            <h1>Тут какой-нибудь очень, очень громкий слоган</h1>
            <div class="banner-buttons">
                <a href="/auto" class="btn btn-default btn-goto">Автомобили</a>
                <a href="#join" class="btn btn-default btn-join btn-join-forjquery">Присоединиться</a>
            </div>
        </div>
    </div>
</div>

<div class="container col-lg-12 col-md-12 col-sm-12" id="join">
    <div class="col-lg-6 col-md-6 col-sm-12 login mini-banner">
        <div class="center-banner">
            <h2>Уже зарегестрированы?</h2>
            <a href="/login" class="btn btn-default btn-join">Войти</a>
        </div>
    </div>
    <div class="col-lg-6 col-md-6 col-sm-12 register mini-banner">
        <div class="center-banner">
            <h2>Новый пользователь?</h2>
            <a href="/register" class="btn btn-default btn-join">Регистрация</a>
        </div>
    </div>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!-- Jquery Script -->
<script>
    $(document).ready(function() {
        $(document).on("scroll", function() {
            $('.navbar-default').css('background', 'rgb(255, 255, 255)');
        });

        $('.btn-join-forjquery').click( function() {
            var scroll_el = $(this).attr('href');
            if ($(scroll_el).length != 0) {
                $('html, body').animate({ scrollTop: $(scroll_el).offset().top }, 500);
            }
            return false;
        });
    });
</script>
</body>
</html>