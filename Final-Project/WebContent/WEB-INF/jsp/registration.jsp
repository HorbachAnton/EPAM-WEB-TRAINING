<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="resources.locale" var="loc" />
    <fmt:message bundle="${loc}" key="locale.registration.enter_email_message" var="enter_email" />
    <fmt:message bundle="${loc}" key="locale.registration.enter_password_message" var="enter_password" />

<div align="right">
<form action="contoller" method="post" >
   <input type="hidden" name="command" value="change_locale">
   <input type="hidden" name="locale" value="ru">
   <input type="submit" name="submit" value="ru" />
</form>
<form action="contoller" method="post" >
   <input type="hidden" name="command" value="change_locale">
   <input type="hidden" name="locale" value="eng">
   <input type="submit" name="submit" value="eng" />
</form>
</div>


 <form action="contoller" method="post" >
    <input type="hidden" name="command" value="registration">
   ${enter_email}:
  	<input type="text" name="email" value=""/>
  	<br/>
  	${enter_password}:  	
  	<input type="password" name="password" value=""/>
  	
  	<br/>
  	
  	<input type="submit" name="submit" value="press me"/>
   </form>
</body>
</html>