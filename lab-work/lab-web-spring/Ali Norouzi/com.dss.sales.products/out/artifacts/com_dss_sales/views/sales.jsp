<%--
  Created by IntelliJ IDEA.
  User: alino
  Date: 8/3/2020
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Sales right now!</title>
</head>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even){background-color: #b6b6b6
    }

    th {
        background-color: #18802a;
        color: #ffffff;
    }
</style>

<body>
<h1>Sales Right Now!</h1>

<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Category</th>
        <th scope="col">Description</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="products" varStatus="counter">
    <tr>
        <th scope="row"><c:out value="${counter.count}"/></th>
        <td>${products.name}</td>
        <td>${products.group.name}</td>
        <td>${products.description}</td>
        <td>${products.price}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
