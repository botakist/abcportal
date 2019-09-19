<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Listing | ABC Portal</title>
<%@include file="styles.jsp" %>
</head>
<body>
<%@include file="NavBar/navbar-admin.jsp" %>
<div class="container job-listing-container">
<s:iterator value="jobDataList">
	<label><s:property value="job_id"/></label>
	<h1><s:property value="job_title" /></h1>
	
		<div class="row">
			<div><label>Scope: </label><p><s:property value="job_scope" /></p></div>
		</div>
		<div class="row">
			<div><label>Salary: </label><p><s:property value="job_salary" /></p></div>
		</div>
		<div class="row">
			<div><label>Availabilty: </label><p><s:property value="job_availability" /></p></div>
		</div>
	
	<div><a href="edit-single-job.action?job_id=<s:property value="job_id" />&submitType=view"><button class="btn btn-warning">Edit This Job Posting</button></a></div>
	<div><a href="admin-delete-job.action?job_id=<s:property value="job_id" />"><button class="btn btn-danger">Delete This Job Posting</button></a></div>
	<p><s:property value="error_message" /></p>
</s:iterator>
</div>
</body>
<%@include file="scripts.jsp" %>
</html>