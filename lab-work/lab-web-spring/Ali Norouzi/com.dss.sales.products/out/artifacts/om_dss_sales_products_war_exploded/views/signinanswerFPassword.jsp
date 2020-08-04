<%--
  Created by IntelliJ IDEA.
  User: alino
  Date: 8/4/2020
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Wrong password</title>
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
    <h1>Incorrect password</h1>
</div>

<span class="btn">
        <a href="signIn">Sign In</a>
    </span>
<span class="btn">
        <a href="signUp">Sign Up</a>
    </span>
<span class="btn">
        <a href="selection">Main page</a>
    </span>
</body>
</html>