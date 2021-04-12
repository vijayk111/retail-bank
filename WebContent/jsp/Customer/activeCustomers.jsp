<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/landing.css">
</head>
<body>
<jsp:include page="../../partial/header.jsp"/>
<div class="container">
	<div class="container">
		<h2>Active Customers</h2>
	</div>
	<div class="container">
		<table>
		    <tr>
		      <th>CusotmerId</th>
		      <th>Name</th>
		      <th>SSN</th>
		      <th>Last Updated</th>
		      <th>Actions</th>
		    </tr>
		    <c:forEach var="cs" items="${list}">
			    <tr>
			      <td>${cs.customerId}</td>
			      <td>${cs.firstname} ${cs.lastname}</td>
			      <td>${cs.ssnId}</td>
			      <td>${cs.lastUpdated}</td>
			      <td><a href="${pageContext.request.contextPath}/customer?id=${cs.ssnId}&ud=u"><i class='far fa-edit'></i></a>
			          <a href="${pageContext.request.contextPath}/customer?id=${cs.ssnId}&ud=d" id="del"><i class='far fa-trash-alt'></i></a>
			      </td>
			    </tr>
		    </c:forEach>
		 </table>
		 <br><br>
		 <form action="${pageContext.request.contextPath}/customer" method="get">
		 	<input type="submit" value="Refresh" id="refresh">
		 </form>
	</div>
</div>

<footer>
<jsp:include page="../../partial/footer.jsp"/>
</footer>
</body>
</html>