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
<div class="alert alert-success" role="alert">
    <h1>Zamówienie zostało pomyślnie opłacone</h1>
    <form action="${pageContext.request.contextPath}/" method="get">
        <input type="submit" class="btn btn-info" value="Powrót na stronę główną">
    </form>
</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
