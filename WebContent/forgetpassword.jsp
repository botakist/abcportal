<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>ABC Portal | Forget Password</title>
<%@include file="styles.jsp"%>
</head>
<body>
	<%@include file="NavBar/navbar-default.jsp" %>
	<div class="container forget-pwd-container">
		<div class="row justify-content-center">
			<p>ABC Portal Forget Password</p>
		</div>
		<div class="row justify-content-center">
			<form action="forgetuser" method="post">
				<div class="form-group">
					<label>Email:</label> <input class="form-control" type="text"
						name="user_email">
				</div>
				<button class="btn btn-warning w-100" type="submit">Send
					Email</button>

				<div class="mt-1 justify-content-start">
					<a href="go-to-login">Go back?</a>
				</div>
			</form>
		</div>
		<div class="row justify-content-center error-message">
			<p>
				<s:property value="error_message" />
			</p>
		</div>

	</div>
<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp" %>
</html>