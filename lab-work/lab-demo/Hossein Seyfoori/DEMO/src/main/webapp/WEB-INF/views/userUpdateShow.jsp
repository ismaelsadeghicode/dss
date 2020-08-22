<%--
  Created by IntelliJ IDEA.
  User: fqx
  Date: 18.08.20
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">


  </head>
  <body>




        <form method="post" action="/userUpdate" class="input-group input-group-sm mb-3">
          <input class="form-control" type="text" name="id" value="${id}" hidden>
          <input class="form-control" type="text" name="name" value="${name}">
          <input class="form-control" type="submit" value="Update">
        </form>





  <table class="table">
    <thead>
    <tr>

      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Operation</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tblusers}" var="tbluser">
        <tr>

          <td>${tbluser.id}</td>
          <td>${tbluser.name}</td>
          </td>
          <td>
            <a href="/tbluser/delete/${tbluser.id}">
               <button type="button" class="btn btn-danger">Delete</button>
            </a>

              <form method="get" action="/userUpdateShow">
                <input type="text" hidden name="id" value=${tbluser.id}>
                <input type="text" hidden name="name" value=${tbluser.name}>
                <input type="submit" class="btn btn-warning" value="Update" />
              </form>


          </td>

        </tr>                                                                                                                                                         
    </c:forEach>

    </tbody>
  </table>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

  </body>
</html>
