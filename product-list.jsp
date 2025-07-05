<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Lista produse</title>
</head>
<body>
    <h2>Produse disponibile</h2>

  <a href="${pageContext.request.contextPath}/products/add">Adaugă produs nou</a></br></br>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nume</th>
            <th>Mărime</th>
            <th>Culoare</th>
            <th>Material</th>
            <th>Preț</th>
            <th>Stock</th>
            <th>Acțiuni</th>
        </tr>
        <c:forEach items="${products}" var="prod">
            <tr>
                <td>${prod.id}</td>
                <td>${prod.name}</td>
                <td>${prod.size}</td>
                <td>${prod.color}</td>
                <td>${prod.material}</td>
                <td>${prod.price}</td>
                <td>${prod.stock}</td>
                <td>
                     <a href="${pageContext.request.contextPath}/products/delete/${prod.id}">Șterge</a>
                     <a href="${pageContext.request.contextPath}/products/edit/${prod.id}">Editează</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
