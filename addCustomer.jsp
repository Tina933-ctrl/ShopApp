<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Adaugă client</title>
</head>
<body>

<h2>Adaugă un client nou</h2></br></br>

<form:form action="${pageContext.request.contextPath}/customers/add" modelAttribute="customer" method="post">

    Nume: <form:input path="name"/><br/>
    Email: <form:input path="email"/><br/>
    Telefon: <form:input path="phone"/><br/>
    Adresă: <form:input path="address"/><br/>
    Total: <form:input path="totalSpent" value="0.0"/>

    <input type="submit" value="Adaugă client"/>
</form:form>

</body>
</html>
