<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 30.10.2019
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%-- TODO: СДЕЛАТЬ INCLUDE --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Бар Хмельная Застава</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body class="bg-light">
    <%@ include file = "header.jsp"%>
    <div class="main">
        <div class="row">
            <div class="col-auto" style="background-color: black">
                <h1 class="display-4 text-center" style="color: white;">
                    <c:choose>
                    <c:when test="${successAuth}">Добро пожаловать, ${username}</c:when>
                    </c:choose> </h1>
                <div id="carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel" data-slide-to="1"></li>
                        <li data-target="#carousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="image/1сarousel.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Первый слайд</h5>
                                <p>Крутой бар.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="image/2carousel.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Второй слайд</h5>
                                <p>Очень крутой бар.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="image/3carousel.jpg" class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Третий слайд</h5>
                                <p>Супер очень крутой бар.</p>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <div class="jumbotron jumbotron-fluid" style="background-color: #000000">
                    <div class="container-fluid">
                        <h1 class="display-4 text-center" style="color: white;">Приятные люди и цены</h1>
                            <div class="row" style="text-align: center; color: white;">
                                <div class="col-lg-4">
                                    <img class="bd-placeholder-img rounded-circle" width="140" height="140" src="image/logo_old.jpg" role="img" aria-label="Placeholder: 140x140">
                                    <h2>Бар "Хмельная Застава"</h2>
                                    <p>Это то место, где вы можете отдохнуть, выпить свежего разливного пива в компании с закусками из кухни на любой вкус и цвет!</p>
                                </div>
                                <div class="col-lg-4">
                                    <img class="bd-placeholder-img rounded-circle" width="140" height="140" src="image/logo_match.jpg" role="img" aria-label="Placeholder: 140x140">
                                    <h2>Актуальные трансляции</h2>
                                    <p>Более 5 телевизоров, проектор. А так же, премиум-подписки на стриминговые сервисы</p>
                                </div>
                                <div class="col-lg-4">
                                    <img class="bd-placeholder-img rounded-circle" width="140" height="140" src="image/map_logo.jpg" role="img" aria-label="Placeholder: 140x140">
                                    <h2>Наше расположение</h2>
                                    <p>Мы рады вас приветствовать ежедневно по адресу ул. Коваленко 52а !
                                        <br>График работы :
                                        <br>с ВС по ЧТ 16:00-02:00
                                        <br>с ПТ по СБ 16:00-03:00</p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="footer mt-auto py-3" style="color:white; background-color: black;">
        <div class="container">
        <p class="float-right">
            <a href="#">Вернуться наверх</a>
        </p>
        <p>© 2014-... Бар "Хмельная застава"</p>

        </div>
    </footer>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
