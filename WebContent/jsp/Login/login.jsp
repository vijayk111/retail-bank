<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
<title>User Login</title>
</head>
<body>

<jsp:include page="../../partial/loginHeader.jsp"/>

<div class="container-fluid" id="smallNav">
	<div class="container" id="navItem">
		<a href="">Home</a>
	</div>
</div>
<form name="loginForm" id="loginForm" action="${pageContext.request.contextPath}/login" method="post">
  <fieldset id="loginPanel">
    <legend>Login to access your Account</legend>
    
    <div class="container" id="loginDiv">
      <label for="username"><b>Username</b></label>      
      <input type="text" name="username" required>
      <br><br>
      <label for="password"><b>Password</b></label>
      <input type="password" name="password" required>
      <br><br>
      <button type="submit">Login</button>     
    </div>    
  </fieldset>
</form>

<footer>
	<jsp:include page="../../partial/footer.jsp"/>
</footer>
</body>
</html>