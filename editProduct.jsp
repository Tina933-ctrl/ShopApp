<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
<meta charset="UTF-8">
<title>Editare produs</title>
</head>

<body>

<form:form action="${pageContext.request.contextPath}/products/update" modelAttribute="product" method="post">
    <form:hidden path="id"/>
    Nume: <form:input path="name"/><br/>
    Mărime: <form:input path="size"/><br/>
    Culoare: <form:input path="color"/><br/>
    Material: <form:input path="material"/><br/>
    Preț: <form:input path="price"/><br/>
    Stoc: <form:input path="stock"/></br>
    <input type="submit" value="Salvează modificările"/>
</form:form>

</body>

</html>