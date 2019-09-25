<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Users</title>
<%@include file="../../styles.jsp"%>
</head>
<body>
<%@include file="../../NavBar/navbar-admin.jsp" %>
	<div class="container">
		<div class="row justify-content-center">
			<h1>ABC User List</h1>
		</div>
	</div>
	<div class="text text-danger"><s:property value="error_msg"/></div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Birthday</th>
				<th>Gender</th>
				<th>Country</th>
				<th>Role</th>
				<th>View</th>
				<th>Delete</th>
		</thead>
		<tbody>
			<s:iterator value="profileDataList">
				<tr>
					<td><s:property value="user_id"/></td>
					<td><s:property value="user_firstname"/></td>
					<td><s:property value="user_lastname"/></td>
					<td><s:property value="user_email"/></td>
					<td><s:property value="user_birthday"/></td>
					<td><s:property value="user_gender"/></td>
					<td><s:property value="user_country"/></td>
					<td><s:property value="user_role"/></td>
					<td><a href="manage-users.action?submitType=viewSingle&profile_id=<s:property value="user_id" />"><button>View</button></a></td>
					<td><a href="manage-users.action?submitType=deleteThisUser&profile_id=<s:property value="user_id" />"><button>Delete</button></a></td>
			</s:iterator>
		</tbody>
	</table>
<%@include file="../../footer/footer.jsp" %>
</body>
<%@include file="../../scripts.jsp" %>
</html>