<!doctype html>
<html lang="en">
<title>ABC Portal</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="styles.jsp"%>

<body>
<%@include file="NavBar/navbar-logged-in.jsp" %>
	<div class="container user-home-container">
		<div class="row justify-content-center mb-2">
			<h2>Welcome Back To ABC Portal</h2>
		</div>
		<div class="row justify-content-center">
			<!-- <form action="searchprofile" method="post">
				<div class="search-query-wrapper d-flex">
					<input class="form-control" type="text" name="search_query"
						placeholder="search..">
					<button type="submit" class="btn btn-info">Search</button>
				</div>
			</form> -->
		</div>
		<!-- <div class="row justify-content-center user_functions">
			<div class="col-3">
				<a href="logout-user"><button class="btn btn-warning">Log
						out</button></a>
			</div>
			<div class="col-3">
				<a href="view-profile"><button class="btn btn-info">View
						Profile</button></a>
			</div>
			<div class="col-3">
				<a href="edit-profile.action?submitType=fetch&"><button
						class="btn btn-info">Edit Profile</button></a>
			</div>
		</div> -->
	</div>
	<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp"%>
</html>