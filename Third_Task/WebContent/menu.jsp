<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="menu.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
	<table>
		<tr>
			<th class="ID">Номер</th>
			<th class="Photo">Фото</th>
			<th class="Title">Название</th>
			<th class="General_Description">Описание</th>
			<th class="Option">Опции</th>
			<th class="Portion">Порция</th>
			<th class="Price">Цена</th>
		</tr>
		<c:forEach var="user" items="${menu}">
			<tr>
				<td class="ID"><c:out value="${user.getId()}" /></td>
				<td class="Photo"><c:out value="${user.getPhotoPath()}" /></td>
				<td class="Title"><c:out value="${user.getTitle()}" /></td>
				<td class="General_Description"><c:out
						value="${user.getGeneralDescription()}" /></td>

				<c:choose>
					<c:when test="${user.getClass().getSimpleName() == 'OptionalFood'}">
						<c:set var="array" value="${user.getFoodOptions()}" />
						<td class="Option"><c:forEach var="option" items="${array}">
								<c:out value="${option.getOptionNumber()}" />.&nbsp;<c:out
									value="${option.getOptionDescription()}" />
								<br>
							</c:forEach></td>
						<td class="Portion"><c:forEach var="option" items="${array}">
								<c:out value="${option.getOptionPortion()}" />
								<br>
							</c:forEach></td>
						<td class="Price"><c:forEach var="option" items="${array}">
								<c:out value="${option.getOptionPrice()}" />
								<br>
							</c:forEach></td>
					</c:when>
					<c:when test="${user.getClass().getSimpleName() == 'GeneralFood'}">
						<td>Нет опций.</td>
						<td><c:out value="${user.getGeneralPortion()}" /></td>
						<td><c:out value="${user.getGeneralPrice()}" /></td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
</body>
</html>