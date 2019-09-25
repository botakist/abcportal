<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Search Results</title>
<%@include file="../styles.jsp"%>
</head>
<body>
<%@include file="../NavBar/navbar-admin.jsp" %>
	<div class="container">
		<div class="row justify-content-center">
			<h2>ABC Portal Search Results</h2>
		</div>
	</div>
	<div style="margin-top: 40px; margin-right: 150px; margin-left: 150px;">
		<table class="table">
			<thead>
				<tr style="background-color: #FEFEFE;">
					<th scope="col">NAME</th>
					<th scope="col">EMAIL</th>
					<th scope="col">BIRTHDAY</th>
					<th scope="col">GENDER</th>
					<th scope="col">COUNTRY</th>
					<th scope="col">ROLE</th>
				</tr>
			</thead>
			<s:iterator value="profileDataList">
				<tr>
					<td><s:property value="user_firstname" />&nbsp;<s:property
							value="user_lastname" /></td>
					<td><s:property value="user_email" /></td>
					<td><s:property value="user_birthday" /></td>
					<td><s:property value="user_gender" /></td>
					<td><s:property value="user_country" /></td>
					<td><s:property value="user_role" /></td>
				</tr>
			</s:iterator>

		</table>
		<div class="error_msg">
			<div class="row justify-content-center">
				<p><s:property value="error_message" /></p>
			</div>
		</div>
		
		 <button onclick="topFunction()" id="myBtn" title="Go to top">Back To Top</button> 
	</div>
<%@include file="../footer/footer.jsp" %>

</body>
<%@include file="../scripts.jsp" %>
</html>