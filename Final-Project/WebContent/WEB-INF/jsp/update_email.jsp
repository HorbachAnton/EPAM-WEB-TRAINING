<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        <title>Update email</title>
      </head>
      <body>

        <fmt:setLocale value="${sessionScope.locale}"/>
        <fmt:setBundle basename="resources.locale" var="loc"/>
        <fmt:message bundle="${loc}" key="locale.default.locale_botton.ru" var="ru"/>
        <fmt:message bundle="${loc}" key="locale.default.locale_botton.en" var="en"/>
        <fmt:message bundle="${loc}" key="locale.update_email.email_message" var="email_message"/>
        <fmt:message bundle="${loc}" key="locale.update_email.email_description" var="email_description"/>
        <fmt:message bundle="${loc}" key="locale.update_email.quality_message" var="quality_message"/>
        <fmt:message bundle="${loc}" key="locale.update_email.quality_description" var="quality_description"/>
        <fmt:message bundle="${loc}" key="locale.update_email.enter_email" var="enter_email"/>

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

          <div class="container form">
            <div class="row">
              <div class="col-sm-4 text-center border border-secondary rounded-lg email">
                <p>
                  ${email_message}
                </p>
                <img src="images/email.png" alt="">
                  <p>
                    ${email_description}
                  </p>
                </div>
                <div class="col-sm-4 border border-secondary rounded-lg registration" style="background:cornsilk;">
                  <form class="text-center" action="contoller" method="post">
                    <input type="hidden" name="command" value="update_email"/>
                    <div class="form-group">
                      <label for="exampleInputEmail1">${enter_email}</label>
                      <input type="email" name="new_email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </form>
                </div>
                <div class="col-sm-4 text-center border border-secondary rounded-lg email">
                  <p>
                    ${quality_message}
                  </p>
                  <img src="images/quality.jpg" alt="">
                    <p>
                      ${quality_description}
                    </p>
                  </div>
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
