<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="utf-8">
						<title>Update Profile</title>
					</head>
					<body>
						<fmt:setLocale value="${sessionScope.local}"/>
						<fmt:setBundle basename="resources.locale" var="loc"/>
						<fmt:message bundle="${loc}" key="locale.update_profile.enter_first_name" var="enter_first_name"/>
						<fmt:message bundle="${loc}" key="locale.update_profile.enter_second_name" var="enter_second_name"/>
						<form action="contoller" method="post">
							<input type="hidden" name="command" value="update_profile">
								<label>${enter_first_name}:</label>
								<input type="text" name="first_name" value=""/>
								<label>${enter_second_name}:</label>
								<input type="text" name="second_name" value=""/>
								<input type="submit" value="Отправить"/>
							</form>
						</body>
					</html>
