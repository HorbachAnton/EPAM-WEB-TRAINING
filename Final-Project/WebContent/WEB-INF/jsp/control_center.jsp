<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8">
          <title>Control center</title>
        </head>
        <body>

          <fmt:setLocale value="${sessionScope.local}"/>
          <fmt:setBundle basename="resources.locale" var="loc"/>
          <fmt:message bundle="${loc}" key="locale.admin_page.cap_id" var="cap_id"/>
          <fmt:message bundle="${loc}" key="locale.admin_page.cap_email" var="cap_email"/>
          <fmt:message bundle="${loc}" key="locale.admin_page.cap_password" var="cap_password"/>
          <fmt:message bundle="${loc}" key="locale.admin_page.cap_first_name" var="cap_first_name"/>
          <fmt:message bundle="${loc}" key="locale.admin_page.cap_second_name" var="cap_second_name"/>
          <fmt:message bundle="${loc}" key="locale.admin_page.cap_role" var="cap_role"/>

          <c:set var="first_user" value="${not empty first_user ? first_user : 0 }"/>
          <c:set var="last_user" value="${not empty last_user ? last_user : 6 }"/>
          
          <table>
            <tr>
              <th class="ID">${cap_id}</th>
              <th class="Email">${cap_email}</th>
              <th class="Password">${cap_password}</th>
              <th class="First_name">${cap_first_name}</th>
              <th class="Second_name">${cap_second_name}</th>
              <th class="Role">${cap_role}</th>
            </tr>
            <c:forEach var="user" items="${users}" begin="${first_user}" end="${last_user}">
              <tr>
                <td class="ID"><c:out value="${user.getId()}"/></td>
                <td class="Email"><c:out value="${user.getEmail()}"/></td>
                <td class="Password"><c:out value="${user.getPassword()}"/></td>
                <td class="First_name"><c:out value="${user.getFirstName()}"/></td>
                <td class="Second_name"><c:out value="${user.getSecondName()}"/></td>
                <td class="Role"><c:out value="${user.getRole()}"/></td>
              </tr>
            </c:forEach>
          </table>

          <c:forEach var="count" begin="0" end="${pages_number}">
            <form action="choosed_page" method="post">
              <input type="submit" name="choosed_page" value="${count + 1}"></form>
            </c:forEach>
          </body>
        </html>
