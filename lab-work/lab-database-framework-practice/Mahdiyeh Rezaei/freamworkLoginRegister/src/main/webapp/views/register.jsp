<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-05
  Time: 00:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body style="background-color: #a57edc" align="center" >
<h1>DSS Register page</h1>
<form method="post" action="register">
    <div class="container">
        <br><br>
        <label><b>Username: </b></label>
        <input type="text" placeholder="Enter Username" name="username" >
        <br>
        <label><b>Password:  </b></label>
        <input type="password" placeholder="Enter Password" name="password" >
        <br>
        <label><b>Repeat Password:  </b></label>
        <input type="password" placeholder="Repeat Password" name="ConfirmPassword" >
    </div>
    <br><br>

    <button type="submit">Register</button>

</form>

</body>
</html>
