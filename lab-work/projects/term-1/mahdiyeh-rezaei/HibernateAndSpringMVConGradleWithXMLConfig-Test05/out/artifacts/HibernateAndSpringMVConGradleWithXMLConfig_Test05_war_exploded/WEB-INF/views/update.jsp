<%--
  Created by IntelliJ IDEA.
  User: ASUSCenter
  Date: 2020-08-21
  Time: 04:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body style="background-color: #95699f" align="center" >
<h1>DSS Update page</h1>
<form method="post" action="updateperson">
    <div class="container">
        <br><br>
        <label><b>Username: </b></label>
        <input type="text" placeholder="Enter Username" name="username" >
        <br>
        <label><b>Password:  </b></label>
        <input type="password" placeholder="Enter New Password" name="password" >
        <br>
        <label><b>Repeat Password:  </b></label>
        <input type="password" placeholder="Re-enter Password" name="password_confirm" >
    </div>
    <br><br>

    <button type="submit">Update</button>

</form>
</body>
</html>
