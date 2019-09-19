<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../styles.jsp" %>
</head>
<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
<div class="container">
	<div class="row">
		<p>Job listing delete error. Please view the error logs, and return to the product listing page.</p>
		<a href="manage-jobs.action?submitType=fetchAll"><button class="btn btn-warning">Return to Listing page</button></a>
		
	</div>
</div>
<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>
</html>