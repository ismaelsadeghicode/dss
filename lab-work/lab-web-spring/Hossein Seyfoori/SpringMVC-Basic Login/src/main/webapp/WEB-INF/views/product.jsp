<%--
  Created by IntelliJ IDEA.
  User: fqx
  Date: 8/4/2020 AD
  Time: 02:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Marvel Slider</title>
    <link rel="stylesheet" href="/static/css/product.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/lightslider.css"/>
    <!--Jquery-->
    <script type="text/javascript" src="/static/js/JQuery3.3.1.js"></script>
    <script type="text/javascript" src="/static/js/lightslider.js"></script>
</head>

<body>



<div class="container">
    <!--slider------------------->
    <ul id="autoWidth" class="cs-hidden">
        <!--1------------------------------>


        <c:forEach items="${products}" var="product">
            <li class="item-a">

                <!--slider-box-->
                <div class="box">
                    <p class="marvel">${product.productName}</p>
                    <!--model-->
                    <img src="/static/images/${product.productPic}" class="model">
                    <!--details-->
                    <div class="details">
                        <!--logo-character-->
                        <!--character-details-->
                        <p>${product.productDescription}</p>
                    </div>

                </div>
            </li>
        </c:forEach>



    </ul>




</div>


<script src="/static/js/script.js" type="text/javascript"></script>
</body>
</html>
