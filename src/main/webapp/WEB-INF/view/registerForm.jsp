<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Sklep z telefonami</title>
</head>
<body>
<%@include file="components/header.jsp" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<div class="container">
    <div class="col-md-6">
        <div class="card">
            <header class="card-header">
                <h4 class="card-title mt-2">Zarejestruj się</h4>
            </header>
            <article class="card-body">
                <form action="${pageContext.request.contextPath}/register" method="post">
                    <div class="form-row">
                        <div class="col form-group">
                            <label>Imię </label>
                            <input type="text" class="form-control" placeholder="Imię" name="firstName">
                        </div> <!-- form-group end.// -->
                        <div class="col form-group">
                            <label>Nazwisko</label>
                            <input type="text" class="form-control" placeholder="Naziwsko" name="lastName">
                        </div> <!-- form-group end.// -->
                    </div> <!-- form-row end.// -->
                    <div class="form-group">
                        <label>Adres E-Mail</label>
                        <input type="email" class="form-control" placeholder="Adres E-Mail" name="email">
                        <small class="form-text text-muted">Twój adres e-mail nie zostanie nigdzie udostępniony</small>
                    </div> <!-- form-group end.// -->
                    <div class="form-group">
                        <label>Login</label>
                        <input type="text" class="form-control" placeholder="Login" name="login">
                        <label>Hasło</label>
                        <input class="form-control" type="password" placeholder="Hasło" name="password">
                    </div> <!-- form-group end.// -->
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block"> Zarejestruj się!</button>
                    </div> <!-- form-group// -->
                    <small class="text-muted">Poprzez kliknięcie przycisku 'Zarejestruj się' akceptujesz nasz regulamin. </small>
                </form>
            </article> <!-- card-body end .// -->
            <div class="border-top card-body text-center">Jesteś już zarejestrowany? <a href="${pageContext.request.contextPath}/login">Zaloguj się</a></div>
        </div> <!-- card.// -->
    </div> <!-- col.//-->
</div>
<!--container end.//-->


<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
