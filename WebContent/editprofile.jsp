<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Edit Profile</title>
<%@include file="styles.jsp"%>
</head>
<body>
<%@include file="NavBar/navbar-logged-in.jsp" %>
	<div class="container edit-profile-container">
		<div class="row justify-content-center">
			<h2>ABC Portal Edit Profile Page</h2>
		</div>
		<div class="row">
			<div
				class="col-md-4 ml-auto justify-content-center align-items-center d-flex">
				<div class="card profile-image-wrapper">
					<div class="card-body">
							<img class="profile-picture" src="assets/img/profile-pic.png">
							<div class="edit-profile text-center">
								<a href="">Change Picture</a>
							</div>
						</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<form action="edit-profile" method="post">
							<div class="form-group">
								<label>First Name:</label> <input class="form-control"
									name="user_firstname" type="text"
									value="<s:property value="user_firstname" />">
							</div>
							<div class="form-group">
								<label>Last Name:</label> <input class="form-control"
									name="user_lastname" type="text"
									value="<s:property value="user_lastname" />">
							</div>
							<div class="form-group">
								<label>Birthday:</label> <input class="form-control"
									name="user_birthday" type="date"
									value="<s:property value="user_birthday"/>">
							</div>
							<div class="form-group">
								<label>Country:</label> <input class="form-control"
									name="user_country" type="text"
									value="<s:property value="user_country"/>">
							</div>
							<div class="edit-submit-wrapper justify-content-end d-flex">
								<button class="btn btn-light w-50" type="submit"
									name="submitType" value="update">Confirm Edit</button>
							</div>

						</form>
					</div>
				</div>

			</div>
		</div>
		<div class="row justify-content-center error-message mt-2">
			<p>
				<s:property value="msg" />
			</p>
		</div>
		<div class="row justify-content-center">
			<a href="view-profile"><button class="btn btn-info">Go
					Back To Profile</button></a>
		</div>


	</div>
	<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp" %>
</html>