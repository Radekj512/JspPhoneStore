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
    <div class="row">
        <c:choose>
            <c:when test="${notLoggedIn}">
                <div class="alert alert-danger"><h1>Musisz być zalogowany!</h1></div>
            </c:when>
            <c:when test="${passChanged}">
                <div class="alert alert-success">Hasło zostało zmienione</div>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${samePass}">
                        <div class="alert alert-danger">Nowe hasło nie może być takie samo jak stare!</div>
                    </c:when>
                    <c:when test="${wrongPass}">
                        <div class="alert alert-danger">Nowe hasło jest niepoprawne!</div>
                    </c:when>
                    <c:when test="${badPass}">
                        <div class="alert alert-danger">Stare hasło jest niepoprawne!</div>
                    </c:when>

                </c:choose>
                <form class="form-horizontal" action="${pageContext.request.contextPath}/changePass" method="post">
                    <div class="form-group">
                        <label for="oldPass" class="col-sm-2 control-label">Stare Hasło</label>
                        <div class="col-sm-3">
                            <input type="password" class="form-control" id="oldPass" name="oldPass"
                                   placeholder="Stare hasło" size="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="newPass" class="col-sm-2 control-label">Nowe hasło</label>
                        <div class="col-sm-3">
                            <input type="password" class="form-control" id="newPass" name="newPass"
                                   placeholder="Nowe hasło"
                                   size="50">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary">Zmień hasło</button>
                        </div>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>


<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
