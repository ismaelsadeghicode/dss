<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-12
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${personList}" var="person">
    <p>ID : ${person.person_id}</p>
    <p>FirstName : ${person.firstName}</p>
    <p>Lastname : ${person.lastName}</p>
    <hr />
</c:forEach>
</body>
</html>
