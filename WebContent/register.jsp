
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<title>ABC Portal | Registration</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="styles.jsp"%>
</head>

<body>
<%@include file="NavBar/navbar-default.jsp" %>
	<div class="container register-container">
		<div class="row justify-content-center">
			<h1>ABC Portal Registration</h1>
		</div>
		<div class="row d-flex justify-content-center">
			<form action="registeruser" method="post">
				<div class="form-group">
					<label for="user_firstname">First Name:</label> <input
						class="form-control" type="text" name="user_firstname"
						id="user_firstname" required>
				</div>
				<div class="form-group">
					<label for="user_lastname">Last Name:</label> <input
						class="form-control" type="text" name="user_lastname"
						id="user_lastname" required>
				</div>
				<div class="form-group">
					<label for="user_email">Email:</label> <input class="form-control"
						type="email" name="user_email" id="user_email" required>
					<div class="error-message">
						<p>
							<s:property value="email_error_message" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label for="user_password">Password:</label> <input
						class="form-control" type="password" name="user_password"
						id="user_password" required>
				</div>
				<div class="form-group">
					<label for="user_confirm_password">Confirm Password:</label> <input
						class="form-control" type="password" name="user_confirm_password"
						id="user_confirm_password" required>
					<div class="error-message">
						<p>
							<s:property value="pwd_error_message" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label for="user_gender">Gender:</label> <select
						class="form-control" name="user_gender" id="user_gender" required>
						<option value="">--Select Gender--</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
				<div class="form-group">
					<label for="user_birthday">Birthday:</label> <input
						class="form-control" type="date" name="user_birthday"
						id="user_birthday" placeholder="yyyy-mm-dd" required>
				</div>
				<div class="form-group">
					<label for="user_country">Country:</label> <select
						class="form-control" name="user_country" id="user_country"
						required>
						<option value="Singapore">Singapore</option>
						<option value="Malaysia">Malaysia</option>
						<option value="Other">Other</option>
					</select>
				</div>

				<div class="row">
					<div class="col-md-6 mb-2 order-md-first">
						<a href="back-to-default"><button type="button"
								class="w-100 btn btn-warning">Back</button></a>
					</div>
					<div class="col-md-6 mb-2 order-sm-first">
						<button type="submit" class="w-100 btn btn-success">Sign
							Up</button>
					</div>
				</div>
			</form>
		</div>


	</div>
<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp"%>
</html>