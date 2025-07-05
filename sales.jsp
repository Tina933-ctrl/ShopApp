<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Lista vânzări</title>
</head>
<body>

<h2>Vânzări înregistrate</h2>

<!-- Link către pagina de adăugare -->
<a href="${pageContext.request.contextPath}/sales/add">Adaugă vânzare nouă</a><br/><br/>

<!-- Tabel cu vânzări -->
<table border="1">
    <tr>
        <th>ID</th>
        <th>Client</th>
        <th>Produs</th>
        <th>Cantitate</th>
        <th>Dată</th>
        <th>Total</th>
        <th>Acțiuni</th>
    </tr>

    <c:forEach items="${sales}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.customerName}</td>
            <td>${s.productName}</td>
            <td>${s.quantity}</td>
            <td>${s.saleDate}</td>
            <td><fmt:formatNumber value="${s.totalPrice}" type="number" maxFractionDigits="2"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/sales/delete/${s.id}">Șterge</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
