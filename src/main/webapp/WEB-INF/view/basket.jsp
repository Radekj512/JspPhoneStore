<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Koszyk</title>
</head>
<body>
<%@include file="components/header.jsp" %>

<div class="container">

    <c:choose>
        <c:when test="${empty phones}">
        <div class="alert alert-info" role="alert">
            <h1>Koszyk jest pusty</h1>
        </div>
        </c:when>
        <c:otherwise>
            <c:forEach items="${phones}" var="phone">
                <div class="row">
                    <div class="col-sm-2">
                        <img src="${phone.imagePath}" alt="${phone.brand} ${phone.model} picture" width="134"
                             height="192"/>
                    </div>
                    <div class="col-sm-6">
                        <a href="${pageContext.request.contextPath}/produkt?id=${phone.id}">
                            <h1>${phone.brand} ${phone.model}</h1></a>
                    </div>
                    <div class="col-sm-2">
                        <fmt:setLocale value="PL-pl"/>
                        <div class="col-sm-12"><fmt:formatNumber type="currency" value="${phone.price}"/></div>
                        <div class="col-sm-12">
                            <form action="${pageContext.request.contextPath}/deleteFromBasket?id=${phone.id}"
                                  method="post">
                                <input type="submit" class="btn btn-warning" value="Usuń z koszyka"/>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="row">
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
                    <form action="${pageContext.request.contextPath}/deleteBasket" method="post">
                        <input type="submit" class="btn btn-danger" value="Wyczyść Koszyk"/>
                    </form>
                </div>
                <div class="col-sm-8 ">
                    <h2>Całkowity koszt: <fmt:formatNumber type="currency" value="${total}"/></h2>
                </div>
            </div>
        </c:otherwise>
    </c:choose>


</div>
<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
