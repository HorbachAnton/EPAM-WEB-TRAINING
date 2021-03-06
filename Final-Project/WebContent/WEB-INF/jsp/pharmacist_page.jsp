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
          <title>Pharmacist Page</title>
        </head>
        <body>
          <fmt:setLocale value="${sessionScope.locale}"/>
          <fmt:setBundle basename="resources.locale" var="loc"/>
          <fmt:message bundle="${loc}" key="locale.default.locale_botton.ru" var="ru"/>
          <fmt:message bundle="${loc}" key="locale.default.locale_botton.en" var="en"/>
          <fmt:message bundle="${loc}" key="locale.pharmacist_page.order_id" var="order_id"/>
          <fmt:message bundle="${loc}" key="locale.pharmacist_page.is_completed" var="is_completed"/>
          <fmt:message bundle="${loc}" key="locale.pharmacist_page.user_first_name" var="user_first_name"/>
          <fmt:message bundle="${loc}" key="locale.pharmacist_page.user_second_name" var="user_second_name"/>

          <c:set var="first_order" value="${not empty first_order ? first_order : 0 }"/>
          <c:set var="last_order" value="${not empty last_order ? last_order : 5 }"/>

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

          <div class="container container_order">
            <div class="row">
              <div class="col-xl-12 col-sm-12 d-flex align-items-center justify-content-center">
                <p>
                  Заказы
                </p>
              </div>
            </div>
            <div class="row d-flex align-items-center justify-content-center border border-secondary header_order">
              <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                ${order_id}
              </div>
              <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                ${is_completed}
              </div>
              <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                ${user_first_name}
              </div>
              <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                ${user_second_name}
              </div>
            </div>
            <c:forEach var="order" items="${listOrders}" begin="${first_order}" end="${last_order}">
              <div class="row d-flex align-items-center justify-content-center border border-secondary row_order">
                <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                  <c:out value="${order.getId()}"/>
                </div>
                <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                  <c:if test="${order.getCompleteStage().getIdentifier() == 0}">
                    Заказ не завершён.
                  </c:if>
                  <c:if test="${order.getCompleteStage().getIdentifier() == 1}">
                    Заказ завершён.
                  </c:if>
                </div>
                <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                  <c:out value="${order.getCustomer().getFirstName()}"/>
                </div>
                <div class="col-xl-3 col-sm-3 d-flex align-items-center justify-content-center">
                  <c:out value="${order.getCustomer().getSecondName()}"/>
                </div>
                <c:if test="${order.getCompleteStage().getIdentifier() == 0}">
                  <form action="contoller" method="post">
                    <input type="hidden" name="command" value="complete_order"/>
                    <input type="hidden" name="id_order" value="${order.getId()}"/>
                    <input type="submit" class="btn btn-secondary" value="Завершить заказ"/>
                  </form>
                </c:if>
              </div>
            </c:forEach>
            <div class="row d-flex align-items-center justify-content-center">
              <c:forEach var="count" begin="0" end="${pages_number}">
                <form class="text-center" action="contoller" method="post">
                  <input type="hidden" name="command" value="choose_order_page"/>
                  <input type="submit" class="btn btn-secondary user_btn" name="choosed_page" value="${count + 1}"/>
                </form>
              </c:forEach>
            </div>
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
