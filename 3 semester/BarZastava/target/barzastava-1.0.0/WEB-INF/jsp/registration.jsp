<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 29.10.2019
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Страница регистрации">

    <title>Регистрация</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/signup.css" rel="stylesheet">
</head>

<body>
<form class="form-signin" method="post">
    <div class="text-center">
    <img class="mb-4" src="image/logo.jpg" width="143" height="143" alt="logo">
    <h1 class="h3 mb-3 font-weight-normal">Пожалуйста, заполните данные</h1>
    </div>
    <div class="form-group">
    <label for="inputEmail" class="text-left">
       <!-- Email адрес
        <c:if test="${userFind != null}">
            <div style="color:red">${userFind}</div>
        </c:if>
        <-->
    </label>

        <div id="emailError" style="color: red"></div>
    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="${emailCheck} Email адрес" required autofocus>
    </div>

    <div class="form-group">
    <label for="inputPassword">Пароль</label>
        <div id="errorPassword" style="color: red"></div>
    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Пароль" required>
     <label for="inputRepeatPassword" class="sr-only">Repeat password</label>
     <input type="password" id="inputRepeatPassword" name="inputRepeatPassword" class="form-control" placeholder="Повторите пароль" required>
    </div>
    <div class="form-group">
        <label for="inputName">Имя пользователя</label>
        <div id="errorName" style="color: red"></div>
    <input id="inputName" name="inputName" class="form-control" placeholder="Имя пользователя">
    </div>
    <div class="form-group">
        <label for="inputAddress">Выберите подходящий(е) вам адрес(а):  </label>
        <select multiple class="form-control" name="inputAddress" id="inputAddress">
            <option selected value="Коваленко, 53а">Коваленко, 53а</option>
            <option value="Б.Хмельницкого, 21">Б.Хмельницкого, 21</option>
            <option value="Пролетарская, 101а">Пролетарская, 101а</option>
            <option value="Мордовская, 35">Мордовская, 35</option>
        </select>
    </div>
    <div class="form-group">
        <label for="inputRole" class="text-left">Введите предопчитаемый адрес, которого нет в списке</label>
        <input id="inputRole" name="inputRole" class="form-control" placeholder="Предпочитаемый адрес" autofocus>
    </div>
    <div class="text-center">Выберите пол: </div>
    <div class="form-check text-center">
        <input type="radio" id="inputGenderMale" name="genderRadios" class="form-check-input" value="Male" checked>
        <label for="inputGenderMale" class="form-check-label">Мужской</label>
    </div>
    <div class="form-check text-center">
        <input type="radio" id="inputGenderFemale" name="genderRadios" class="form-check-input" value="Female">
        <label for="inputGenderFemale" class="form-check-label">Женский</label>
    </div>
    <div class="form-check text-center">
        <input class="form-check-input" type="checkbox" value="accepted" id="checkAccepted" name="checkAccepted">
        <label class="form-check-label" for="checkAccepted">
            Согласие на обработку данных
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block"style="background-color: #1b6216; border-color: #1b6216;" type="submit">Зарегистрироваться</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
<script src="js/regformcheck.js"></script>
</body>
</html>
