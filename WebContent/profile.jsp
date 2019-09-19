<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="styles.jsp"%>

</head>
<body>
<%@include file="NavBar/navbar-logged-in.jsp" %>
	<div class="container profile-container">
		<div class="row justify-content-center">
			<h2>ABC Portal Profile Page</h2>
		</div>
		<div class="profile-wrapper mt-2">
			<div class="row">
				<div
					class="col-md-6 profile-image-wrapper d-flex justify-content-center">
					<div class="card">
						<div class="card-body">
							<img class="profile-picture" src="assets/img/profile-pic.png">
							<div class="edit-profile text-center">
								<a href="">Change Picture</a>
							</div>
						</div>

					</div>

				</div>
				<div class="col-md-6 profile-details-wrapper">
					<s:iterator value="profileDataList">
						<div class="row">
							<label>Name:&nbsp;</label><span><s:property
									value="user_firstname" />&nbsp;<s:property
									value="user_lastname" /></span>
						</div>
						<div class="row">
							<label>Email:&nbsp;</label><span><s:property
									value="user_email" /></span>
						</div>
						<div class="row">
							<label>Birthday:&nbsp;</label><span><s:property
									value="user_birthday" /></span>
						</div>
						<div class="row">
							<label>Gender:&nbsp;</label><span><s:property
									value="user_gender" /></span>
						</div>
						<div class="row">
							<label>Country:&nbsp;</label><span><s:property
									value="user_country" /></span>
						</div>
						<div class="row">
							<label>Role:&nbsp;</label><span><s:property
									value="user_role" /></span>
						</div>
					</s:iterator>
					<s:property value="error_message" />
				</div>
			</div>
		</div>
	<div class="row user_functions p-2">
	<div class="col-md-6">
				<a href="back-to-home"><button class="btn btn-warning">Home
						Page</button></a>
			</div>
			<div class="col-md-6">
				<a href="edit-profile.action?submitType=fetch&"><button
						class="btn btn-info">Edit Profile</button></a>
			</div>
			
		</div>
	</div>
	
	<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp"%>
</html>