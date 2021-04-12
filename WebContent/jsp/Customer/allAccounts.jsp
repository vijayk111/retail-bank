<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>all accounts</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/landing.css">
</head>
<body>
<jsp:include page="../../partial/header.jsp"/>
<div class="container">
	<div class="container">
		<h2>Account Status</h2>
	</div>
	<div class="container">
		<table>
		    <tr>
		      <th>CustomerId</th>
		      <th>Account Id</th>
		      <th>Account Type</th>
		      <th>Account Status</th>
		      <th>Balance</th>
		      <th>Last Transaction</th>	      
		      
		    </tr>
		    <c:forEach var="ca" items="${list}">
			    <tr>
			      <td>${ca.customerID}</td>
			      <td>${ca.accountId}</td>
			      <td>${ca.accountType}</td>
			      <td>
			      	<c:choose>
			      		<c:when test="${ca.status eq 'closed'}">
			      			<b style="color:red;">${cs.status}</b>
			      		</c:when>
			      		<c:otherwise>${ca.status}</c:otherwise>
			      	</c:choose>
			      </td>
			      <td>${ca.balance}</td>
			      <td>${ca.lastTransaction}</td>			      
			    </tr>
		    </c:forEach>
		 </table>
		 <br><br>
		 <form action="${pageContext.request.contextPath}/account" method="get">
		 	<input type="hidden" name="v" value="getall">
		 	<input type="submit" value="Refresh" id="refresh">
		 </form>
	</div>
</div>

<footer>
<jsp:include page="../../partial/footer.jsp"/>
</footer>
</body>
</html>