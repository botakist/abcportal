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
	<h1>ABC Portal Job Listings</h1>
</div>
<div class="row justify-content-center d-flex">
	<div class="col"><a href="manage-jobs.action?submitType=fetchAll"><button>View All Jobs</button></a></div>
	<div class="col"><a href="admin-post-new"><button>Post Job</button></a></div>
	<div class="col"><a href="view-admin-postings.action?adminId=<s:property value="user_id" />&submitType=fetchAdmin"><button>View My Own Job Postings</button></a></div>
</div>
<div class="container">
	<table class="table">
			<thead>
				<tr style="background-color: #FEFEFE;">
					<th scope="col">No.</th>
					<th scope="col">TITLE</th>
					<th scope="col">AVAILABILITY</th>
					<th scope="col">Posted By</th>
					<th scope="col">View</th>
					<th scope="col">Edit</th>
				</tr>
			</thead>
			<s:iterator value="jobDataList">
				<tr>
					<td><s:property value="job_id" /></td>
					<td><s:property value="job_title" /></td>
					<td><s:property value="job_availability" /></td>
					<td><s:property value="user_id"/></td>
					<td><a href="view-single-job.action?singleJobId=<s:property value="job_id"/>&submitType=fetchSingle"><button class="btn btn-info">View Job</button></a></td>
					<td><a href="edit-single-job.action?job_id=<s:property value="job_id"/>&submitType=view"><button class="btn btn-warning">Edit</button></a></td>
				</tr>
			</s:iterator>

		</table>
		</div>
		<%@include file="footer/footer.jsp" %>
</body>
<%@include file="scripts.jsp" %>
</html>