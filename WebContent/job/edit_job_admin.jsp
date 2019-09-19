<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Edit Job Posting</title>
<%@include file="../styles.jsp"%>
</head>
<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
	<div class="container edit-profile-container">
		<div class="row justify-content-center">
			<h2>ABC Portal Edit Job Posting Page</h2>
		</div>
		<div class="row">
			<div class="col-12">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<label>Job Posting ID: <s:property value="job_id" /></label>
						</div>
						<form action="edit-single-job.action?job_id=<s:property value="job_id" />" method="post">
							<div class="form-group">
								<label>Job Title:</label> <input class="form-control"
									name="job_title" type="text"
									value="<s:property value="job_title" />">
							</div>
							<div class="form-group">
								<label>Job Scope:</label> <input class="form-control"
									name="job_scope" type="text"
									value="<s:property value="job_scope" />">
							</div>
							<div class="form-group">
								<label>Job :</label> <input class="form-control"
									name="job_salary" type="text"
									value="<s:property value="job_salary"/>">
							</div>
							<div class="form-group">
								<label></label> <input class="form-control"
									name="job_availability" type="text"
									value="<s:property value="job_availability"/>">
							</div>
							<div class="edit-submit-wrapper justify-content-end d-flex">
								
							</div>
							<div class="edit-submit-wrapper row d-flex justify-content-around">
							<div class="col-4"><button class="btn btn-info w-100" type="submit" name="submitType" value="cancel">Cancel</button></div>
							<div class="col-4"><button class="btn btn-warning w-100" type="submit" name="submitType" value="update">Confirm Update</button></div>
								
							</div>

						</form>
					</div>
				</div>

			</div>
		</div>
		<div class="row justify-content-center error-message mt-2">
			<p>
				<s:property value="error_message" />
			</p>
		</div>


	</div>
	<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>
</html>