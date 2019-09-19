<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Edit Thread</title>
<%@include file="../styles.jsp"%>
</head>
<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
	<div class="container edit-profile-container">
		<div class="row justify-content-center">
			<h2>ABC Portal Edit Profile Page</h2>
		</div>
		<div class="row">
				<div class="card">
					<div class="card-body">
						<form action="manage-threads" method="post">
							<div class="form-group">
								<label>Thread Subject: </label> <input class="form-control"
									name="thread_subject" type="text"
									value="<s:property value="thr_subject" />">
							</div>
							<div class="edit-submit-wrapper justify-content-end d-flex">
								<button class="btn btn-light w-50" type="submit"
									name="submitType" value="updateListing">Confirm Edit</button>
							</div>

						</form>
					</div>
				</div>

		</div>
		<div class="row justify-content-center error-message mt-2">
			<p>
				<s:property value="error_msg" />
			</p>
		</div>
		<div class="row justify-content-center">
			<a href="view-admin-profile"><button class="btn btn-info">Go
					Back To Profile</button></a>
		</div>


	</div>
	<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>
</html>