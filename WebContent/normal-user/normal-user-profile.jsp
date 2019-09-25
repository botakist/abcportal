<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC | User Profile</title>
<%@include file="../styles.jsp"%>
</head>
<body>
<%@include file="../NavBar/navbar-logged-in.jsp" %>
<div class="container">
	<h1>Profile</h1>
	<s:iterator value="profileDataList">
		<p><s:property value="user_id" /></p>
		<p><s:property value="user_firstname" /></p>
		<p><s:property value="user_lastname" /></p>
		<p><s:property value="user_email" /></p>
		<p><s:property value="user_birthday" /></p>
		<p><s:property value="user_gender" /></p>
		<p><s:property value="user_country" /></p>
		<p><s:property value="user_role" /></p>
	</s:iterator>
	<a href="manage-users.action?submitType=viewAll"><button class="btn btn-info">Go Back</button></a>
</div>
<%@include file="../footer/footer.jsp" %>
</body>
<%@include file="../scripts.jsp" %>	
</html>