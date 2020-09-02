<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-17
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>person list</title>
  </head>
  <body>
  <c:forEach items="${persons}" var="person">
    <p>id: ${person.id}</p>
    <p>username: ${person.username}</p>
    <p>password: ${person.password}</p>
    <hr/>
  </c:forEach>
  </body>
</html>
