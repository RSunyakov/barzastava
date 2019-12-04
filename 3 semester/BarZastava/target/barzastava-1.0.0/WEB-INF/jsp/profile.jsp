<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 01.12.2019
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Профиль Пользователя</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container emp-profile">
    <form method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="profile-head">
                    <h2>
                        ${user.getUsername()}
                    </h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Имя</label>
                            </div>
                            <div class="col-md-6">
                                <p>${user.getUsername()}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Почта</label>
                            </div>
                            <div class="col-md-6">
                                <p>${user.getEmail()}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Пол</label>
                            </div>
                            <div class="col-md-6">
                                <p>${user.getGender()}</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Любимые адреса баров</label>
                            </div>
                            <div class="col-md-6">
                                <c:forEach items="${roles}" var="role">
                                    <p>${role.getRole()}</p>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Изменить профиль"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
