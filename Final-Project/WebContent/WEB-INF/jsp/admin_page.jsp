<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="utf-8">
          <title>Admin page</title>
        </head>
        <body>
          <form action="controller" method="post">
            <input type="submit" value="Центр управления пользователями"/>
          </form>
          <form action="controller" method="post">
            <input type="submit" value="Центр управления товарами"/>
          </form>
          <form action="controller" method="post">
            <input type="submit" value="Вывести пользователей"/>
          </form>
          <form action="controller" method="post">
            <input type="submit" value="Вывести товары"/>
          </body>
        </html>
