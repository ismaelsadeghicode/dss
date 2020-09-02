<%--
  Created by IntelliJ IDEA.
  User: ali
  Date: 8/19/20
  Time: 2:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Users List</title>
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
<h1>Users List</h1>

<table class="table table-striped table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">ID</th>
        <th scope="col">Email</th>
        <th scope="col">Username</th>
        <th scope="col">Password</th>
        <th scope="col">PhoneNumber</th>
        <th scope="col">Wallet</th>
        <th scope="col">Is Male</th>
        <th scope="col">Is Female</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usersList}" var="usersList" varStatus="counter">
        <tr>
            <th scope="row"><c:out value="${counter.count}"/></th>
            <td>${usersList.id}</td>
            <td>${usersList.emailAdress}</td>
            <td>${usersList.username}</td>
            <td>${usersList.password}</td>
            <td>${usersList.phoneNumber}</td>
            <td>${usersList.wallet}</td>
            <td>${usersList.male}</td>
            <td>${usersList.female}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>