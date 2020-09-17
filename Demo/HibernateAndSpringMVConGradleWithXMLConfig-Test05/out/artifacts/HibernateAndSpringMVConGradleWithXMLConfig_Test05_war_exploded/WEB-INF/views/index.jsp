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
    <title>$Title$</title>
  </head>
  <body>
  <c:forEach items="${products}" var="product" >
    <p>name: ${product.id}</p>
    <p>price: ${product.name}</p>
    <p>category: ${product.price}</p>
    <p>brand: ${product.brand}</p>
    <p>id: ${product.category}</p>
    <hr/>
  </c:forEach>
  </body>
</html>
