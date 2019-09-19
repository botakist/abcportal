<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Post Job Success</title>
<%@include file="../styles.jsp" %>
</head>
<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
<div class="container">
	<div class="row justify-content-center">
		<p>Job Posting success. Please proceed back to the job listing page.</p>
		<a href="manage-jobs.action?submitType=fetchAll"><button class="btn btn-success">Return to Listing page</button></a>
	</div>
</div>
<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>
</html>