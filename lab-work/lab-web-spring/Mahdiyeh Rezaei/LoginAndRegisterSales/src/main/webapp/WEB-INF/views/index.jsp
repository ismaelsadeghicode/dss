<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-05
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${products}" var="product" >
        <p>name: ${product.name}</p>
        <p>price: ${product.price}</p>
        <p>category: ${product.category}</p>
        <hr/>
    </c:forEach>
</body>
</html>
