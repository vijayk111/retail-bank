<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Customer</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<jsp:include page="../../partial/header.jsp"/>
<div class="container">
	<form id="customerForm" action="${pageContext.request.contextPath}/customer" method="post">
	  <fieldset id="customerPanel">
	      <legend>Register/Create Customer</legend>	    
	      <div class="container" id="formDiv">
	        <label for="firstname"><b>Firstname</b></label>      
	        <input type="text" name="firstname" required>
	        <br><br>
	        <label for="lastname"><b>Lastname</b></label>      
	        <input type="text" name="lastname" required>
	        <br><br>
	        <label for="ssn"><b>SSN ID</b></label>
	        <input type="text" name="ssn" required>
	        <br><br>
	        <label for="dob"><b>Date of Birth</b></label>
	        <input type="date" name="dob" required>
	        <br><br>
	        <label for="address1"><b>Address Line 1</b></label>
	        <input type="text" name="address1">
	        <br><br>
	        <label for="address2"><b>Address Line 2</b></label>
	        <input type="text" name="address2">
	        <br><br>
	        <label for="city"><b>City</b></label>
	        <input type="text" name="city">
	        <br><br>
	        <label for="state"><b>State</b></label>
	        <select name="state">
	        	<option value="state1">state1</option>
	        	<option value="state2">state2</option>
	        </select>
	        <br><br>
	        <label for="zipcode"><b>Zip Code</b></label>
	        <input type="text" name="zipcode">
	        <br><br>
	        <input type="hidden" value="add" name="action">
	        <button type="submit">Create</button>     
	      </div>    
      </fieldset>
	</form>
</div>

<footer>
<jsp:include page="../../partial/footer.jsp"/>
</footer>
</body>
</html>