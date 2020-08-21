<%--
  Created by IntelliJ IDEA.
  User: ali
  Date: 8/19/20
  Time: 2:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>${updatedUser.id}</title>
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
<h1>${updatedUser.emailAdress}</h1>

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
    <c:forEach items="${updatedUser}" var="updatedUser" varStatus="counter">
        <tr>
            <th scope="row"><c:out value="${counter.count}"/></th>
            <td>${updatedUser.id}</td>
            <td>${updatedUser.emailAdress}</td>
            <td>${updatedUser.username}</td>
            <td>${updatedUser.password}</td>
            <td>${updatedUser.phoneNumber}</td>
            <td>${updatedUser.wallet}</td>
            <td>${updatedUser.male}</td>
            <td>${updatedUser.female}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>