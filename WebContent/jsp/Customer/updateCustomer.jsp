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
<script>
				function1(){
					document.getElementById('Show').style.display='none';
					document.getElementById('Hide').style.display='block';
					document.getElementById('createAccount').style.display='block';
				}
				function2(){
					document.getElementById('Show').style.display='block';
					document.getElementById('Hide').style.display='none';
					document.getElementById('createAccount').style.display='none';
				}
</script>
</head>
<body>
<jsp:include page="../../partial/header.jsp"/>
<div class="container">
	<h2>View/Edit Customer</h2>
</div>
<div class="container">
<form id="customerForm" action="${pageContext.request.contextPath}/customer" method="post">
	  <fieldset id="customerPanel">
	      <legend>Register/Create Customer</legend>
	      	<label><b>CustomerId :</b>  ${c.customerId}</label>
	        <label for="firstname"><b>Firstname</b></label>      
	        <input type="text" name="firstname" value="${c.firstname}" required>
	        <br><br>
	        <label for="lastname"><b>Lastname</b></label>      
	        <input type="text" name="lastname" value="${c.lastname}" required>
	        <br><br>
	        <label for="ssn"><b>SSN ID</b></label>
	        <input type="text" name="ssn" value="${c.ssnId}" required>
	        <br><br>
	        <label for="dob"><b>Date of Birth</b></label>
	        <input type="date" name="dob" value="${c.dob}" required>
	        <br><br>
	        <label for="address1"><b>Address Line 1</b></label>
	        <input type="text" name="address1" value="${c.addressLine1}" >
	        <br><br>
	        <label for="address2"><b>Address Line 2</b></label>
	        <input type="text" name="address2" value="${c.addressLine2}">
	        <br><br>
	        <label for="city"><b>City</b></label>
	        <input type="text" name="city" value="${c.city}">
	        <br><br>
	        <label for="state"><b>State</b></label>
	        <select name="state" ${c.dob}>
	        	<option value="state1" ${c.dob== 'state1' ? 'selected':''}>state1</option>
	        	<option value="state2" ${c.dob== 'state2' ? 'selected':''}>state2</option>
	        </select>
	        <br><br>
	        <label for="zipcode"><b>Zip Code</b></label>
	        <input type="text" name="zipcode" value="${c.zipcode}">
	        <br><br>
	        <input type="hidden" value="update" name="action">
	        <input type="hidden" value="${c.customerId}" name="id">
	        <button type="submit">Save</button>
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
	<br><br>
			<button id="show" onclick="function1()" style="display: block;">Create New Account</button>
			<button id="hide" onclick="function2()" style="display: none;">Cancel</button>			
			<div class="container">
			 <form id="createAccount" action="${pageContext.request.contextPath}/account" method="post">
			 	<label><b>CustomerId: </b>  ${c.customerId}</label>
			 	<br><br>
			 	<label for="type"><b>Accout Type: </b></label>
			 	<select name="type">
			 		<option value="Savings">Savings</option>
			 		<option value="Checking">Checking</option>
			 	</select>
			 	<br><br>
			 	<label for="depositAmount"><b>Deposit Amount: </b></label>
			 	<input type="text" name="depositAmount">
			 	<br><br>
			 	<input type="hidden" name="action" value="add">
			 	<input type="hidden" name="ssnid" value="${c.ssnId}">
			 	<input type="hidden" name="cid" value="${c.customerId}">
			 	<input type="submit" value="Create"><br>
			 </form>
			 </div>
</div>

<footer>
<jsp:include page="../../partial/footer.jsp"/>
</footer>
</body>
</html>