<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Listing Page</title>
<%@include file="../styles.jsp"%>
</head>
<body>
<%@include file="../NavBar/navbar-default.jsp" %>
<div class="container">
	<h1>User Listing Page</h1>
</div>
<table class="table table-striped">
	<thead>
		<tr>
			<th scope="col">NAME</th>
			<th scope="col">EMAIL</th>
			<th scope="col">BIRTHDAY</th>
			<th scope="col">GENDER</th>
			<th scope="col">COUNTRY</th>
			<th scope="col">ROLE</th>
			<th scope="col">View</th>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="profileDataList">
			<tr>
				<td><s:property value="user_id"/></td>
				<td><s:property value="user_firstname"/></td>
				<td><s:property value="user_lastname"/></td>
				<td><s:property value="user_email" /></td>
				<td><s:property value="user_birthday" /></td>
				<td><s:property value="user_gender" /></td>
				<td><s:property value="user_country" /></td>
				<td><s:property value="user_role" /></td>
				<td><a href="manage-users.action?submitType=viewSingle&profile_id=<s:property value="user_id"/>">View</a></td>
			</tr>
		</s:iterator>
	</tbody>
</table>
<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>	
</html>