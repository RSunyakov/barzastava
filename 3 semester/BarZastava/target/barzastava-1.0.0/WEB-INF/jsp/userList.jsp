<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 12.11.2019
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<table class="table">
    <tr>
        <th scope="col">e-mail</th>
        <th scope="col">Password</th>
        <th scope="col">Name</th>
        <th scope="col">Country</th>
        <th scope="col">Description</th>
        <th scope="col">Gender</th>
        <th scope="col">Accepted</th>
    </tr>
    <c:forEach var="user" items="${userList}">
    <tr>
        <td>${user.getEmail()}</td>
        <td>${user.getPassword()}</td>
        <td>${user.getName()}</td>
        <td>${user.getCountry()}</td>
        <td>${user.getDescription()}</td>
        <td>${user.getGender()}</td>
        <td>${user.isAccepted()}</td>
    </tr>
</c:forEach>
</table>
<form method="post">
    <button type="submit" name="nameButton" class="btn btn-secondary">Отсортировать по имени</button>
    <button type="submit" name="countryButton" class="btn btn-secondary">Отсортировать по стране</button>
</form>
</body>
</html>
