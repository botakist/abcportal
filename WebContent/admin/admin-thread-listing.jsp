<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Thread Listing</title>
<%@include file="../styles.jsp"%>
</head>
<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
	<div class="container">
		<div class="row justify-content-center">
			<h2>ABC Admin Thread Listing</h2>
		</div>
	</div>
	<div style="margin-top: 40px; margin-right: 150px; margin-left: 150px;">
		<table class="table">
			<thead>
				<tr style="background-color: #FEFEFE;">
					<th scope="col">ID</th>
					<th scope="col">THREAD SUBJECT</th>
					<th scope="col">TOTAL THREAD MESSAGES</th>
					<th scope="col">CREATED BY</th>
					<th scope="col">VIEW</th>
					<th scope="col">EDIT</th>
				</tr>
			</thead>
			<s:iterator value="threadDataList">
				<tr>
					<td><s:property value="thr_id"/></td>
					<td><s:property value="thr_subject" /></td>
					<td></td>
					<td><s:property value="user_id" /></td>
					<td><a href="manage-threads.action?submitType=viewSingle"><button class="btn btn-info">View</button></a></td>
					<td><a href="manage-threads.action?submitType=editListing"><button class="btn btn-warning">Edit Details</button></a></td>
				</tr>
			</s:iterator>

		</table>
		
		 <button onclick="topFunction()" id="myBtn" title="Go to top">Back To Top</button> 
	</div>
<%@include file="../footer/footer.jsp" %>

</body>
<%@include file="../scripts.jsp" %>
</html>