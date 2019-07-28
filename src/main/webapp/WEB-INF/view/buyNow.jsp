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
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <img src="${phone.imagePath}" alt="${phone.brand} ${phone.model} picture" width="134"
                 height="192"/>
        </div>
        <div class="col-sm-7">
            <h1 class="text-center">${phone.brand} ${phone.model}</h1>
            <h6 class="text-center">System operacyjny: ${phone.operatingSystem}</h6>
            <h6 class="text-center">Przednia kamera: ${phone.secondaryCameraMp}</h6>
            <h6 class="text-center">Tylna kamera: ${phone.primaryCameraMp}</h6>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8">
            <h2>Razdem do zapłaty: <fmt:formatNumber type="currency" maxFractionDigits="2" value="${phone.price}"/></h2>
        </div>
        <div class="col-sm-2">
            <c:choose>
                <c:when test="${isLogin}">
                    <form action="${pageContext.request.contextPath}/buy" method="post">
                        <input type="submit" class="btn btn-default" value="Zapłać"/>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="${pageContext.request.contextPath}/login" method="get">
                        Aby dokończyć zakup musisz się zalogować<input type="submit" class="btn btn-info" value="Zaloguj się"/>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-2">
            <form action="${pageContext.request.contextPath}/" method="get">
                <input type="submit" class="btn btn-danger" value="Anuluj"/>
            </form>
        </div>
    </div>
</div>


<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
