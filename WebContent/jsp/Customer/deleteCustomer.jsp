<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update customer</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<jsp:include page="../../partial/header.jsp"/>
<div class="container">
	<h2>View/Edit Customer</h2>
</div>
<div class="container">
<form id="customerForm" action="${pageContext.request.contextPath}/customer" method="post">
	  <fieldset id="customerPanel">
	      <legend>Customer Info</legend>
	      	<label><b>CustomerId :</b>  ${c.customerId}</label>
	      	<br><br>
	        <label><b>Firstname :</b>  ${c.firstname}</label> 
	        <br><br>
	        <label><b>Lastname :</b>  ${c.lastname}</label>
	        <br><br>
	        <label><b>SSN ID :</b>  ${c.ssnId }</label>
	        <br><br>
	        <label><b>Date of Birth :</b>  ${c.dob }</label>
	        <br><br>
	        <label><b>Address Line 1 :</b>  ${c.addressLine1 }</label>
	        <br><br>
	        <label><b>Address Line 2 :</b>  ${c.addressLine2 }</label>
	        <br><br>
	        <label><b>City :</b>  ${c.city }</label>
	        <br><br>
	        <label><b>State :</b>  ${c.state }</label>
	        <br><br>
	        <label><b>Zip Code :</b>  ${c.zipcode }</label>
	        <br><br>
      </fieldset>
	</form>
	
	<div class="container">
	<h3>Accounts</h3>
		<table>
		    <tr>
		      <th>Account Id</th>
		      <th>Account Type</th>
		      <th>Account Status</th>
		      <th>Balance</th>
		      <th>Last Transaction</th>
		      <th>Action</th>
		    </tr>
		    <c:forEach var="ca" items="${list}">
			    <tr>
			      <td>${ca.accountId}</td>
			      <td>${ca.accountType}</td>
			      <td>${ca.status}</td>
			      <td>${ca.balance}</td>
			      <td>${ca.lastTransaction}</td>
			      <td>
			      	<c:choose>
					   <c:when test="${ca.status.equals('closed')}"><a href="" style="color:DodgerBlue;">re-open</a></c:when>
					   <c:when test="${ca.status.equals('open')}"><a href="" style="color:DodgerBlue;">close</a></c:when>
					   <c:otherwise></c:otherwise>
					</c:choose>
			      </td>
			    </tr>
		    </c:forEach>
		 </table>		 
	</div>
	<div class="container">		
		<form action="${pageContext.request.contextPath}/customer" method="post" id="cabutton">
		<br><br>
			<c:set var="checkval" value="${'no'}"/>
			<c:forEach var="ca" items="${list}">	
			<c:choose>
				<c:when test="${ca.status eq 'open'}">
					<c:set var="checkval" value="${'yes'}"/>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${checkval eq 'yes'}">
				<label>Are you sure?There are still open accounts!</label>
			</c:when>
			<c:otherwise><label>Are you sure?</label></c:otherwise>
		</c:choose>
		<br><br>
			<a href="${pageContext.request.contextPath}/customer">Cancel</a>
			<input type="hidden" value="del" name="action">
			<input type="hidden" name="cid" value="${c.customerId}">
			<input type="submit" value="Delete">
		</form>
	</div>
</div>

<footer>
<jsp:include page="../../partial/footer.jsp"/>
</footer>
</body>
</html>