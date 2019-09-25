
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<title>ABC Admin | Job Posting</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="../styles.jsp"%>
</head>

<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
	<div class="container register-container">
		<div class="row justify-content-center">
			<h1>ABC Portal Registration</h1>
		</div>
		<div class="row d-flex justify-content-center">
			<form action="admin-create-new" method="post">
				<div class="form-group">
					<label for="job_title">Job Title: </label> <input
						class="form-control" type="text" name="job_title"
						id="job_title" required>
				</div>
				<div class="form-group">
					<label for="job_scope">Job Scope:</label> <input
						class="form-control" type="text" name="job_scope"
						id="job_scope" required>
				</div>
				<div class="form-group">
					<label for="job_salary">Salary: </label> <input class="form-control"
						type="text" name="job_salary" id="job_salary" required>
					<div class="error-message">
						<p>
							<s:property value="job_salary_error_message" />
						</p>
					</div>
				</div>
				<div class="form-group">
					<label for="job_availabilty">Availability:</label> <select
						class="form-control" name="job_availability" id="job_availability" required>
						<option value="Open">Default(Open)</option>
						<option value="Closed">Closed</option>
					</select>
				</div>

				<div class="row">
					<div class="col-md-6 mb-2 order-md-first">
						<a href="manage-jobs.action?submitType=fetchAll"><button type="button"
								class="w-100 btn btn-warning">Back</button></a>
					</div>
					<div class="col-md-6 mb-2 order-sm-first">
						<button type="submit" class="w-100 btn btn-success">Post Job</button>
					</div>
				</div>
			</form>
		</div>


	</div>
<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp"%>
</html>