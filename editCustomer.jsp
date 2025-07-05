<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
<meta charset="UTF-8">
<title>Editare client</title>
</head>

<body>

<form:form action="${pageContext.request.contextPath}/customers/update" modelAttribute="customer" method="post">
    <form:hidden path="id"/>
    Nume: <form:input path="name"/><br/>
    Email: <form:input path="email"/><br/>
    Telefon: <form:input path="phone"/><br/>
    Adresa: <form:input path="address"/><br/>
    <input type="submit" value="Salvează modificările"/>
</form:form>

</body>

</html>