<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
      <!DOCTYPE html>
      <html>
        <head>
          <!-- Required meta tags -->
          <meta charset="utf-8"/>
          <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

          <!-- Bootstrap CSS -->
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
          <link rel="stylesheet" href="css/style.css"/>
          <title>User Page</title>
        </head>
        <body>

          <fmt:setLocale value="${sessionScope.local}"/>
          <fmt:setBundle basename="resources.locale" var="loc"/>
          <fmt:message bundle="${loc}" key="locale.default.locale_botton.ru" var="ru"/>
          <fmt:message bundle="${loc}" key="locale.default.locale_botton.en" var="en"/>
          <fmt:message bundle="${loc}" key="locale.user_page.cap_id" var="cap_id"/>
          <fmt:message bundle="${loc}" key="locale.user_page.cap_title" var="cap_title"/>
          <fmt:message bundle="${loc}" key="locale.user_page.cap_type" var="cap_type"/>
          <fmt:message bundle="${loc}" key="locale.user_page.cap_description" var="cap_description"/>
          <fmt:message bundle="${loc}" key="locale.user_page.cap_dosage" var="cap_dosage"/>
          <fmt:message bundle="${loc}" key="locale.user_page.cap_need_recipe" var="cap_need_recipe"/>

          <c:set var="first_medicine" value="${not empty first_medicine ? first_medicine : 0 }"/>
          <c:set var="last_medicine" value="${not empty last_medicine ? last_medicine : 5 }"/>

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
                  <div class="carousel-item"><img src="images/3.jpg" alt="" class="d-block w-100"/></div>
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

            <div class="container user_container">
              <div class="row">
                <div class="col-sm-4 text-center d-flex align-items-center justify-content-center flex-column border border-secondary rounded-lg profile_service">
                  <p>
                    Если вы хотите изменить свой профиль просто нажмите кнопку.
                  </p>
                  <form action="contoller" method="post">
                    <input type="hidden" name="command" value="go_to_update_profile_page"/>
                    <input type="submit" class="btn btn-secondary" name="submit" value="Обновить профиль"/>
                  </form>
                </div>
                <div class="col-sm-4 text-center d-flex align-items-center justify-content-center flex-column border border-secondary rounded-lg hello_part">
                  <p class="hello_phrase">
                    Hello,
                    <c:out value="${sessionScope.user.firstName}"/>
                    <c:out value="${sessionScope.user.secondName}"/>
                  </p>
                  <form action="contoller" method="post">
                    <input type="hidden" name="command" value="go_to_order_page"/>
                    <input type="submit" class="btn btn-secondary" name="submit" value="Перейти к заказу"/>
                  </form>
                </div>
                <div class="col-sm-4 text-center d-flex align-items-center justify-content-center flex-column border border-secondary rounded-lg profile_service">
                  <p>
                    Если вы хотите обновить свой пароль или email просто нажмите кнопку.
                  </p>
                  <form action="contoller" method="post">
                    <input type="hidden" name="command" value="go_to_update_password_page"/>
                    <input type="submit" class="btn btn-secondary" name="submit" value="Обновить пароль"/>
                  </form>
                  <form action="contoller" class="email_form" method="post">
                    <input type="hidden" name="command" value="go_to_update_email_page"/>
                    <input type="submit" class="btn btn-secondary" name="submit" value="Обновить email"/>
                  </form>
                </div>
              </div>
            </div>

            <div class="container container_medicine">
              <div class="row">
                <div class="col-xl-12 col-sm-12 d-flex align-items-center justify-content-center">
                  <p>
                    Доступные лекарства
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
              <c:forEach var="medicine" items="${listMedicines}" begin="${first_medicine}" end="${last_medicine}">
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
                      Необходим рецепт.
                    </c:if>
                    <c:if test="${!medicine.isNeedPrescription()}">
                      Рецепт не нужен.
                    </c:if>
                  </div>
                  <form action="contoller" method="post" accept-charset="utf-8">
                    <input type="hidden" name="command" value="add_to_order"/>
                    <input type="hidden" name="selected_medicine_id" value="${medicine.getId()}"/>
                    <input type="hidden" name="selected_medicine_name" value="${medicine.getName()}"/>
                    <input type="hidden" name="selected_medicine_type" value="${medicine.getType()}"/>
                    <input type="hidden" name="selected_medicine_description" value="${medicine.getDescription()}"/>
                    <input type="hidden" name="selected_medicine_dosage" value="${medicine.getDosage()}"/>
                    <input type="hidden" name="selected_medicine_need_prescription" value="${medicine.isNeedPrescription()}"/>
                    <input type="submit" class="btn btn-secondary user_btn" name="submit" value="Добавить в заказ"/>
                  </form>
                  <c:if test="${medicine.isNeedPrescription()}">
                    <form action="contoller" method="post">
                      <input type="hidden" name="command" value="request_prescription"/>
                      <input type="hidden" name="userId" value="${sessionScope.user.getId()}"/>
                      <input type="hidden" name="medicineId" value="${medicine.getId()}"/>
                      <input type="submit" class="btn btn-secondary user_btn" name="submit" value="Запросить рецепт"/>
                    </form>
                  </c:if>
                </div>
              </c:forEach>
              <div class="row d-flex align-items-center justify-content-center">
                <c:forEach var="count" begin="0" end="${pages_number}">
                  <form class="text-center" action="contoller" method="post">
                    <input type="hidden" name="command" value="choose_medicine_page"/>
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

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

          </body>
        </html>
