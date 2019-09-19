<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal</title>
<%@include file="styles.jsp"%>
</head>
<body>
<%@include file="NavBar/navbar-default.jsp" %>
	<div class="container forget-pwd-ty-container">
		<div class="row justify-content-center">
			<h2>ABC Portal</h2>
		</div>
		<div class="row justify-content-center">
			<p>Your password is sent to your email. Please check your email
				address.</p>
		</div>
		<div class="row justify-content-center">
			<a href="go-to-login"><button type="button" class="btn btn-info">Go
					to Login</button></a>
		</div>
	</div>
<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp" %>
</html>