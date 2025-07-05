<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Lista clienți</title>
</head>
<body>

<h2>Clienți înregistrați</h2>

<a href="${pageContext.request.contextPath}/customers/add">Adaugă client nou</a></br></br>


<table border="1">
    <tr>
        <th>ID</th>
        <th>Nume</th>
        <th>Email</th>
        <th>Telefon</th>
        <th>Adresă</th>
        <th>TotalSpent</th>
        <th>Acțiuni</th>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.phone}</td>
            <td>${c.address}</td>
            <td><fmt:formatNumber value="${c.totalSpent}" type="number" maxFractionDigits="2"/></td>
            <td>
            <a href="${pageContext.request.contextPath}/customers/delete/${c.id}">Șterge</a>
            <a href="${pageContext.request.contextPath}/customers/edit/${c.id}">Editeaza</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
