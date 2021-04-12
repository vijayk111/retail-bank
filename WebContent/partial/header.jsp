<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/header.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<div class="container-fluid" id="header">
		<h2 id="retail">Retail</h2>
		<h2 id="bank"> Bank</h2>
</div>
<div class="container" id="smallNavbar">
	<div class="container" id="navItem">
	<ul id="menu">
		<li><a href="${pageContext.request.contextPath}/customer?up=getactive">Home</a></li>
		<li><a href="${pageContext.request.contextPath}/jsp/Customer/createCustomer.jsp">Create Customer</a></li>
		<li><form action="" name="" id="search">
			<select name="searchby">
				<option value="SSNID">SSNID</option>
				<option value="CustomerID">CustomerID</option>
			</select>
			<input type="text" name="searchval">
			<input type="submit" value="Search">
		</form></li>
		<li><select onChange="window.location.href=this.value" id="details">
			<option value="">Status Details</option>
			<option value="${pageContext.request.contextPath}/account?v=getall">All Account Details</option>
			<option value="${pageContext.request.contextPath}/customer?ud=getall">All Customer Details</option>
		</select></li>
	</ul>
	</div>
</div>
<br><br>
</body>
</html>