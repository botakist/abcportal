<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="styles.jsp"%>

<body>
<%@include file="NavBar/navbar-default.jsp" %>
	<div class="container login-container">
		<div class="row justify-content-center">
			<h2>ABC Portal Login</h2>
		</div>
		<div class="row d-flex justify-content-center">
			<form action="loginuser" method="post">
				<div class="form-group">
					<label>Username:</label> <input class="form-control" type="text"
						required name="email">
				</div>
				<div class="form-group">
					<label>Password:</label> <input class="form-control"
						type="password" required name="password">
					<div class="row justify-content-end">
						<small><a href="go-to-forget-pwd">Forget Password?</a></small>
					</div>
				</div>
				<div class="login-cta">
					<button type="submit" class="w-100 btn btn-success">Login</button>
				</div>

			</form>
		</div>
		<div class="sign-up-cta">
			<div class="row justify-content-center">
				<p>Don't have an account? Sign up for one!</p>
			</div>
			<div class="row justify-content-center">
				<a href="go-to-registration"><button class="btn btn-info w-100">Sign
						Up</button></a>
			</div>
			<div class="row error-message">
				<small><p>
						<s:property value="message" />
					</p></small>
			</div>
		</div>

	</div>
	<%@include file="/footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp"%>
</html>