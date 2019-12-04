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
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="profile-head">
                    <h2>
                        ${user.getUsername()}
                    </h2>
                    <c:if test="${checkEdit}">
                    <div style="color: red">
                    <h2>Данные неверные</h2>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-8">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Имя</label>
                            </div>
                            <div class="col-md-6">
                               <input name="inputName" id="inputName" value="${user.getUsername()}">
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
                                <div class="form-check text-center form-check-inline">
                                    <input type="radio" id="inputGenderMale" name="genderRadios" class="form-check-input" value="Male" checked>
                                    <label for="inputGenderMale" class="form-check-label">Мужской</label>
                                </div>
                                <div class="form-check text-center form-check-inline">
                                    <input type="radio" id="inputGenderFemale" name="genderRadios" class="form-check-input" value="Female">
                                    <label for="inputGenderFemale" class="form-check-label">Женский</label>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Любимые адреса баров</label>
                            </div>
                            <div class="col-md-6">
                                <select multiple class="form-control" name="inputAddress" id="inputAddress">
                                    <option selected value="Коваленко, 53а">Коваленко, 53а</option>
                                    <option value="Б.Хмельницкого, 21">Б.Хмельницкого, 21</option>
                                    <option value="Пролетарская, 101а">Пролетарская, 101а</option>
                                    <option value="Мордовская, 35">Мордовская, 35</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>Новый пароль</label>
                            </div>
                            <div class="form-group col-md-6">
                                <input name="inputPassword" id="inputPassword" type="password" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
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
