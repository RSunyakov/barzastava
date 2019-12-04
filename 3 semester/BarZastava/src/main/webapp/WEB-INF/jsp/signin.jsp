<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 17.11.2019
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход в аккаунт</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/signup.css" rel="stylesheet">
</head>
<body class="text-center">
    <form class="form-signin" method="post">
        <img class="mb-4" src="image/logo.jpg" width="143" height="143" alt="logo">
        <h1 class="h3 mb-3 font-weight-normal">Пожалуйста, заполните данные</h1>
        <h1 class="h3 mb-3 font-weight-normal" style="color: red">${fail}</h1>
        <label for="inputEmail" class="sr-only">Email адрес</label>
        <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="${requestScope.emailCheck} Email адрес" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Пароль" required>
        <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me">Запомнить меня
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block " style="background-color: #1b6216; border-color: #1b6216;" type="submit">Войти</button>
        <p class="mt-5 mb-3 text-muted">© 2019-2020</p>
    </form>
</body>
</html>
