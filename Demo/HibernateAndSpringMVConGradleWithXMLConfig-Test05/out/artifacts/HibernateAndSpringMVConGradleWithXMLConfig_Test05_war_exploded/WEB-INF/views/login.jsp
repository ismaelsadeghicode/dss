<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-04
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login-page</title>
</head>
<body style="background-color: #8c7edc" align="center" >
<h1>DSS Login page</h1>
<form method="post" action="login">
    <div class="container">
        <br><br>
        <label><b>Enter Username: </b></label>
        <input type="text" placeholder="Enter Username" name="username" >
        <br>
        <label><b>Enter Password:  </b></label>
        <input type="password" placeholder="Enter Password" name="password" >
    </div>
    <br><br>

    <button type="submit">Login</button>
    <button >
        <a href="/register" >Register</a>
    </button>

</form>


</body>
</html>
