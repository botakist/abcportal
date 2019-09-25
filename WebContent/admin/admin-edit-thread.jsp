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
			<h2>ABC Portal Edit Thread Name / Subject</h2>
		</div>
		<div class="row justify-content-center">
				<div class="card">
					<div class="card-body">
					<s:if test="threadDataList.isEmpty()">
						<div class="row justify-content-center error-message mt-2">
							<p><s:property value="error_msg" /></p>
						</div>
					</s:if>
					<s:else>
					<s:iterator value="threadDataList">
						<form action="manage-threads.action?submitType=updateListing" method="post">
							<div class="form-group">
								
									<label>Thread Subject: </label>
									
										<input type="hidden" name="thr_id" value="<s:property value="thr_id" />" />
										<input class="form-control"
											name="thr_subject" type="text"
											value="<s:property value="thr_subject" />">
									
							</div>
							<div>
								<input type="submit" value="submit" class="btn btn-warning">
							</div>
						</form>
						<form action="manage-threads.action?submitType=deleteThread" method="post">
						
							<div class="mt-3">
								<input type="hidden" name="thr_id" value="<s:property value="thr_id" />" />
								<input type="submit" value="delete this thread" class="btn btn-danger"/>
							</div>
						</form>
						</s:iterator>
					</s:else>
						
						
					</div>
				</div>

		</div>
		
		<div class="row justify-content-center mt-3">
			<a href="manage-threads.action?submitType=viewAll"><button class="btn btn-info">Go
					Back To Thread Listing</button></a>
		</div>


	</div>
	<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>
</html>