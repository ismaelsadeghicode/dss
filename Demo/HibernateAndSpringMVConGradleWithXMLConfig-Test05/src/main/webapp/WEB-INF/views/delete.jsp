<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-21
  Time: 03:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete-person</title>
</head>
<body style="background-color: #5969ba" align="center" >
<h1>DSS Delete page</h1>
<form method="post" action="deleteperson">
    <div class="container">
        <br><br>
        <label><b>Enter Username: </b></label>
        <input type="text" placeholder="Enter Username" name="username" >
    </div>
    <br><br>

    <button type="submit">Delete</button>
</form>
</body>
</html>
