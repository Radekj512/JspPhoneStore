<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>${product.brand} ${product.model} - Sklep z telefonami</title>
</head>
<body>
<%@include file="components/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <img src="${product.imagePath}" alt="${product.brand} ${product.model} picture" width="134"
                 height="192"/>
        </div>
        <div class="col-sm-7">
            <h1 class="text-center">${product.brand} ${product.model}</h1>
            <h6 class="text-center">System operacyjny: ${product.operatingSystem}</h6>
            <h6 class="text-center">Przednia kamera: ${product.secondaryCameraMp}</h6>
            <h6 class="text-center">Tylna kamera: ${product.primaryCameraMp}</h6>
        </div>
        <div class="col-sm-2">
            <div class="col-12">
                <form action="${pageContext.request.contextPath}/addToBasket?id=${product.id}" method="post">
                    <input type="submit" class="btn btn-default" value="Do Koszyka"/>
                </form>
            </div>
            <div class="col-12">
                <form action="${pageContext.request.contextPath}/buyNow?id=${product.id}" method="post">
                    <input type="submit" class="btn btn-default" value="Kup teraz"/>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
