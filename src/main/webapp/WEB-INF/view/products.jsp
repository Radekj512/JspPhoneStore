<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Sklep z telefonami</title>
</head>
<body>

<%@include file="components/header.jsp" %>

<div class="container-fluid">
    <div class="col-sm-2"><%@include file="components/productsFilter.jsp" %></div>
    <div class="col-sm-10">
        <c:forEach items="${products}" var="product">
            <div class="row">
                <div class="col-sm-2">
                    <img src="${product.imagePath}" alt="${product.brand} ${product.model} picture" width="134"
                         height="192"/>
                </div>
                <div class="col-sm-6">
                    <a href="${pageContext.request.contextPath}/produkt?id=${product.id}">
                        <h1>${product.brand} ${product.model}</h1></a>
                    <h6>System operacyjny: ${product.operatingSystem}</h6>
                    <h6>Przednia kamera: ${product.secondaryCameraMp}</h6>
                    <h6>Tylna kamera: ${product.primaryCameraMp}</h6>
                </div>
                <div class="col-sm-2">
                    <fmt:setLocale value="PL-pl"/>
                    <div class="col-12"><fmt:formatNumber type="currency" value="${product.price}"/></div>
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
        </c:forEach>
    </div>
</div>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
