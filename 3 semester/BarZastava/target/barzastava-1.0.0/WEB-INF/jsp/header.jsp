<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 01.12.2019
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark justify-content-between" style="background-color: #000000;">
        <a class="navbar-brand mx-auto" href="index">
            <img class="" src="image/logo.jpg" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Меню</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Бронь</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        Акции
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Контакты</a>
                </li>
            </ul>
            <ul class="navbar-nav justify-content-end">
                <c:if test="${user == null}">
                <li class="nav-item" style="color:rgba(255,255,255,0.5);"><a class="nav-link" href="signin">Войти</a></li>
                <li class="nav-item" style="color:rgba(255,255,255,0.5);"><a class="nav-link" href="reg">Зарегистрироваться</a></li>
                </c:if>
                <c:if test="${user != null}">
                    <li class="nav-item" style="color:rgba(255,255,255,0.5);"><a class="nav-link" href="profile">Профиль</a></li>
                    <li class="nav-item" style="color:rgba(255,255,255,0.5);"><a class="nav-link" href="signout">Выйти</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

