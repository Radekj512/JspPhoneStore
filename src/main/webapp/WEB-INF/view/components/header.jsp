
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <p class="navbar-brand"><a href="${pageContext.request.contextPath}/" class="navbar-link"> Sklep z telefonami</a></p>
        </div>
        <div class="navbar-right">
            <p class="navbar-text"><a href="${pageContext.request.contextPath}/basket" class="navbar-link">Koszyk</a></p>
            <c:choose>
                <c:when test="${isLogin}">
                    <p class="navbar-text"><a href="${pageContext.request.contextPath}/changePass" class="navbar-link">Zmień hasło</a></p>
                    <p class="navbar-text"><a href="${pageContext.request.contextPath}/logOut" class="navbar-link">Wyloguj się</a></p>
                </c:when>
                <c:otherwise>
                    <p class="navbar-text"><a href="${pageContext.request.contextPath}/login" class="navbar-link">Zaloguj się</a></p>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</nav>

