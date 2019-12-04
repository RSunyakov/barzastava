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

<body class="text-center">
<form class="form-signin" method="post">
    <img class="mb-4" src="image/logo.jpg" width="143" height="143" alt="logo">
    <h1 class="h3 mb-3 font-weight-normal">Пожалуйста, заполните данные</h1>
    <label for="inputEmail" class="sr-only">Email адрес</label>
    <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="${emailCheck} Email адрес" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Пароль" required>
    <label for="inputRepeatPassword" class="sr-only">Repeat password</label>
    <input type="password" id="inputRepeatPassword" name="inputRepeatPassword" class="form-control" placeholder="Повторите пароль" required>
    <input id="inputName" name="inputName" class="form-control" placeholder="Имя пользователя">
    <div class="form-group">
        <label for="inputCountry" class="sr-only">Выберите страну: </label>
        <select class="form-control" name="inputCountry" id="inputCountry">
            <option value="Default"selected>Выберите страну</option>
            <option value="Russian Federation">Russian Federation</option>
            <option value="Rwanda">Rwanda</option>
            <option value="Saint Helena">Saint Helena</option>
            <option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
            <option value="Saint Lucia">Saint Lucia</option>
            <option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option>
            <option value="Saint Vincent and The Grenadines">Saint Vincent and The Grenadines</option>
            <option value="Samoa">Samoa</option>
            <option value="San Marino">San Marino</option>
            <option value="Sao Tome and Principe">Sao Tome and Principe</option>
            <option value="Saudi Arabia">Saudi Arabia</option>
            <option value="Senegal">Senegal</option>
            <option value="Serbia">Serbia</option>
            <option value="Seychelles">Seychelles</option>
            <option value="Sierra Leone">Sierra Leone</option>
        </select>
    </div>
    <div class="form-group">
        <label for="inputAbout" class="sr-only">О себе:</label>
        <textarea class="form-control" id="inputAbout" name="inputAbout" rows="3" placeholder="О себе"></textarea>
    </div>
    <label for="inputGenderFemale">Выберите пол: </label>
    <div class="form-check">
        <input type="radio" id="inputGenderMale" name="genderRadios" class="form-check-input" value="Male">
        <label for="inputGenderMale" class="form-check-label">Male</label>
    </div>
    <div class="form-check">
        <input type="radio" id="inputGenderFemale" name="genderRadios" class="form-check-input" value="Female">
        <label for="inputGenderFemale" class="form-check-label">Female</label>
    </div>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" name="checkAccepted" value="accepted"> Cогласие на обработку данных
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block"style="background-color: #1b6216; border-color: #1b6216;" type="submit">Зарегистрироваться</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
</form>
</body>
</html>
