<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
      <!DOCTYPE html>
      <html>
        <head>
          <meta charset="utf-8">
            <title>Insert title here</title>
          </head>
          <body>

            <fmt:setLocale value="${sessionScope.local}"/>
            <fmt:setBundle basename="resources.locale" var="loc"/>
            <fmt:message bundle="${loc}" key="locale.user_page.cap_id" var="cap_id"/>
            <fmt:message bundle="${loc}" key="locale.user_page.cap_title" var="cap_title"/>
            <fmt:message bundle="${loc}" key="locale.user_page.cap_type" var="cap_type"/>
            <fmt:message bundle="${loc}" key="locale.user_page.cap_description" var="cap_description"/>
            <fmt:message bundle="${loc}" key="locale.user_page.cap_dosage" var="cap_dosage"/>
            <fmt:message bundle="${loc}" key="locale.user_page.cap_need_recipe" var="cap_need_recipe"/>

            <c:set var="first_medicine" value="${not empty first_medicine ? first_medicine : 0 }"/>
            <c:set var="last_medicine" value="${not empty last_medicine ? last_medicine : 6 }"/>

            <h1>HELLO,</h1>
            <h2>
              <c:out value="${sessionScope.user.firstName}"/>
            </h2>

            <form action="contoller" method="post">
              <input type="hidden" name="command" value="go_to_update_profile_page"/>
              <input type="submit" name="submit" value="Обновить профиль"/>
            </form>

            <form action="contoller" method="post">
              <input type="hidden" name="command" value="go_to_update_password_page"/>
              <input type="submit" name="submit" value="Обновить пароль"/>
            </form>

            <form action="contoller" method="post">
              <input type="hidden" name="command" value="go_to_update_email_page"/>
              <input type="submit" name="submit" value="Обновить email"/>
            </form>

            <form action="contoller" method="post">
              <input type="hidden" name="command" value="go_to_order_page"/>
              <input type="submit" name="submit" value="Перейти к заказу"/>
            </form>

            <table>
              <tr>
                <th class="ID">${cap_id}</th>
                <th class="Title">${cap_title}</th>
                <th class="Type">${cap_type}</th>
                <th class="Description">${cap_description}</th>
                <th class="Dosage">${cap_dosage}</th>
                <th class="Need_prescription">${cap_need_recipe}</th>
              </tr>
              <c:forEach var="medicine" items="${listMedicines}" begin="${first_medicine}" end="${last_medicine}">
                <tr>
                  <td class="ID"><c:out value="${medicine.getId()}"/></td>
                  <td class="Title"><c:out value="${medicine.getName()}"/></td>
                  <td class="Type"><c:out value="${medicine.getType()}"/></td>
                  <td class="Description"><c:out value="${medicine.getDescription()}"/></td>
                  <td class="Dosage"><c:out value="${medicine.getDosage()}"/></td>
                  <td class="Need_prescription">
                    <c:if test="${medicine.isNeedPrescription()}">
                      Необходим рецепт.
                    </c:if>
                    <c:if test="${!medicine.isNeedPrescription()}">
                      Рецепт не нужен.
                    </c:if>
                  </td>
                  <td>
                    <form action="contoller" method="post" accept-charset="utf-8">
                      <input type="hidden" name="command" value="add_to_order"/>
                      <input type="hidden" name="selected_medicine_id" value="${medicine.getId()}"/>
                      <input type="hidden" name="selected_medicine_name" value="${medicine.getName()}"/>
                      <input type="hidden" name="selected_medicine_type" value="${medicine.getType()}"/>
                      <input type="hidden" name="selected_medicine_description" value="${medicine.getDescription()}"/>
                      <input type="hidden" name="selected_medicine_dosage" value="${medicine.getDosage()}"/>
                      <input type="hidden" name="selected_medicine_need_prescription" value="${medicine.isNeedPrescription()}"/>
                      <input type="submit" name="submit" value="Добавить в заказ"/>
                    </form>
                  </td>
                  <c:if test="${medicine.isNeedPrescription()}">
                    <td>
                      <form action="contoller" method="post">
                        <input type="hidden" name="command" value="request_prescription"/>
                        <input type="hidden" name="userId" value="${sessionScope.user.getId()}"/>
                        <input type="hidden" name="medicineId" value="${medicine.getId()}"/>
                        <input type="submit" name="submit" value="Запросить рецепт"/>
                      </form>
                    </td>
                  </c:if>
                </tr>
              </c:forEach>
            </table>

            <c:forEach var="count" begin="0" end="${pages_number}">
              <form action="choosed_page" method="post">
                <input type="submit" name="choosed_page" value="${count + 1}"></form>
              </c:forEach>

            </body>
          </html>
