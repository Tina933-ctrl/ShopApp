<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Adaugă vânzare</title>
</head>
<body>

<h2>Adaugă o vânzare nouă</h2>

<c:if test="${not empty error}">
    <div style="color: red;">${error}</div>
</c:if>


<form:form action="${pageContext.request.contextPath}/sales/save" modelAttribute="sale" method="post">

     <label>Client:</label>
       <form:select path="customerId">
           <form:options items="${customers}" itemValue="id" itemLabel="name"/>
       </form:select>
       <br/><br/>

      <label>Produs:</label>
      <form:select path="productId">
          <c:forEach var="product" items="${products}">
              <option value="${product.id}" ${product.stock == 0 ? 'disabled' : ''}>
                  ${product.fullName} ${product.stock == 0 ? ' (stoc epuizat)' : ''}
              </option>
          </c:forEach>
      </form:select>

       <label>Cantitate:</label>
       <form:input path="quantity"/>
       <br/><br/>


       <input type="submit" value="Adaugă vânzare"/>
   </form:form>

</body>
</html>
