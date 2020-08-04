<%--
  Created by IntelliJ IDEA.
  User: alino
  Date: 8/3/2020
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Registration</title>
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
  <h1>Choose one of given options</h1>
</div>

<span class="btn">
        <a href="signIn.jsp">Sign In</a>
    </span>
<span class="btn">
        <a href="signUp.jsp">Sign Up</a>
    </span>
</body>
</html>