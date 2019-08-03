<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/produkty" method="get">
    <c:forEach items="${brands}" var="brand">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="marka" value="${brand}"} ${checkedBrands.contains(brand) ? "checked" : ""}>
            <label class="form-check-label">
                    ${brand}
            </label>
        </div>
    </c:forEach>
    <button type="submit" class="btn btn-default">Filtruj</button>
</form>
<form action="${pageContext.request.contextPath}/" method="get">
    <button type="submit" class="btn btn-danger">Wyczyść filtry</button>
</form>