<%@ page language="java" import="by.horant.fintask.entity.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8">
          <title>Insert title here</title>
        </head>
        <body>

          <h1>HELLO,</h1>
          <h2>

            <c:out value="${requestScope.user.firstName}"/>
          </h2>

        </body>
      </html>