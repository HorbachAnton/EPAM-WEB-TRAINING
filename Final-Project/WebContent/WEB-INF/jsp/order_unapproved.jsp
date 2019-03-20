<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
      <!DOCTYPE html>
      <html lang="en">
        <head>
          <!-- Required meta tags -->
          <meta charset="utf-8"/>
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

          <!-- Bootstrap CSS -->
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
          <link rel="stylesheet" href="css/style.css"/>
          <title>Unapproved_order</title>
        </head>
        <body>
          <fmt:setLocale value="${sessionScope.locale}"/>
          <fmt:setBundle basename="resources.locale" var="loc"/>
          <fmt:message bundle="${loc}" key="locale.default.locale_botton.ru" var="ru"/>
          <fmt:message bundle="${loc}" key="locale.default.locale_botton.en" var="en"/>
          <fmt:message bundle="${loc}" key="locale.unapproved_order.cap_id" var="cap_id"/>
          <fmt:message bundle="${loc}" key="locale.unapproved_order.cap_title" var="cap_title"/>
          <fmt:message bundle="${loc}" key="locale.unapproved_order.cap_type" var="cap_type"/>
          <fmt:message bundle="${loc}" key="locale.unapproved_order.cap_description" var="cap_description"/>
          <fmt:message bundle="${loc}" key="locale.unapproved_order.cap_dosage" var="cap_dosage"/>
          <fmt:message bundle="${loc}" key="locale.unapproved_order.cap_need_recipe" var="cap_need_recipe"/>

          <c:set var="listMedicines" value="${sessionScope.medication_without_recipes.getMedicinesWithoutRecipes()}"/>

          <nav class="navbar navbar-expand-lg navbar-light sticky-top">
            <a class="navbar-brand" href="#"><img src="./images/logo.png"/></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
                <form action="contoller" method="post">
                  <input type="hidden" name="command" value="change_locale"/>
                  <input type="hidden" name="locale" value="ru"/>
                  <input type="submit" class="btn btn-secondary" name="submit" value="${ru}" style="width:60px;"/>
                </form>
                <form action="contoller" method="post">
                  <input type="hidden" name="command" value="change_locale"/>
                  <input type="hidden" name="locale" value="eng"/>
                  <input type="submit" class="btn btn-secondary" name="submit" value="${en}" style="width:60px; margin-left:20px;"/>
                </form>
              </ul>
              <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
              </div>
            </nav>

            <div class="container-fluid slider">
              <div id="carousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                  <li class="active" data-target="#carousel" data-slide-to="1"></li>
                  <li data-target="#carousel" data-slide-to="2"></li>
                  <li data-target="#carousel" data-slide-to="3"></li>
                </ol>
                <div class="carousel-inner">
                  <div class="carousel-item active">
                    <img src="images/1.jpg" alt="" class="d-block w-100"/></div>
                  <div class="carousel-item">
                    <img src="images/2.jpg" alt="" class="d-block w-100"/></div>
                  <div class="carousel-item">
                    <img src="images/3.jpg" alt="" class="d-block w-100"/></div>
                </div>
                <a href="#carousel" class="carousel-control-prev" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a href="#carousel" class="carousel-control-next" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
            </div>
          </div>

          <div class="container your_order_container">
            <div class="row">
              <div class="col-xl-12 col-sm-12 d-flex align-items-center justify-content-center">
                <p>
                  Следующие товары не могут быть добавлены в заказ, так как у вас недостаточно рецептов на их покупку. Вы можете купить их позже, запросив соответствующий рецепт. Чтобы заказать остальные товары из вашего списка, просто удалите нижележащие товары из
                  заказа.
                </p>
              </div>
            </div>
            <div class="row d-flex align-items-center justify-content-center border border-secondary header_medicine">
              <div class="col-xl-1 col-sm-1 d-flex align-items-center justify-content-center">
                ${cap_id}
              </div>
              <div class="col-xl-1 col-sm-1 d-flex align-items-center justify-content-center">
                ${cap_title}
              </div>
              <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                ${cap_type}
              </div>
              <div class="col-xl-4 col-sm-4 d-flex align-items-center justify-content-center">
                ${cap_description}
              </div>
              <div class="col-xl-1 col-sm-1 d-flex align-items-center justify-content-center">
                ${cap_dosage}
              </div>
              <div class="col-xl-2 col-sm-2 d-flex align-items-center justify-content-center">
                ${cap_need_recipe}
              </div>
            </div>
            <c:forEach var="medicine" items="${listMedicines}">
              <div class="row d-flex align-items-center justify-content-center border border-secondary row_medicine">
                <div class="col-xl-1 col-sm-1 d-flex align-items-center justify-content-center">
                  <c:out value="${medicine.getId()}"/>
                </div>
                <div class="col-xl-1 col-sm-1 d-flex align-items-center justify-content-center">
                  <c:out value="${medicine.getName()}"/>
                </div>
                <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                  <c:out value="${medicine.getType()}"/>
                </div>
                <div class="col-xl-4 col-sm-4 d-flex align-items-center justify-content-center">
                  <p class="text-center">
                    <c:out value="${medicine.getDescription()}"/>
                  </p>
                </div>
                <div class="col-xl-1 col-sm-1 d-flex align-items-center justify-content-center">
                  <c:out value="${medicine.getDosage()}"/>
                </div>
                <div class="col-xl-2 col-sm-2 d-flex align-items-center justify-content-center">
                  <c:if test="${medicine.isNeedPrescription()}">
                    Отпускается по рецепту
                  </c:if>
                  <c:if test="${!medicine.isNeedPrescription()}">
                    Отпускается без рецепта
                  </c:if>
                </div>
              </div>
            </c:forEach>
            <form action="contoller" class="d-flex align-items-center justify-content-center" method="post">
              <input type="hidden" name="command" value="delete_medicine_without_recipes"/>
              <input type="hidden" name="medication_without_recipes" value="${medication_without_recipes}"/>
              <input type="submit" class="btn btn-secondary" value="Удалить товары без рецепта из заказа"/>
            </form>
          </div>

          <footer class="footer navbar-fixed-bottom">
            <div class="container">
              <div class="row">
                <div class="col-sm-12 text-center">
                  <p>
                    onlinepharmacy.com
                  </p>
                </div>
              </div>
            </div>
          </footer>

          <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
          <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </body>
      </html>
