<%--
  Created by IntelliJ IDEA.
  User: ali
  Date: 8/19/20
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Done</title>
</head>
<style>
    .btn{
        padding:5px 20px;
        border: 1px solid black;
        margin:5px;
        color: white;
        background-color: #000;
        transition: .3s ease-in-out;
    }
    .btn:hover{
        color:black;
        background-color: white;
    }
    a{
        text-decoration: none;
    }
</style>
<body>
<div>
    <h1>User has been added to the database</h1>
</div>

<span class="btn">
        <a href="admin"> <== Back to admin </a>
    </span>
</body>
</html>
