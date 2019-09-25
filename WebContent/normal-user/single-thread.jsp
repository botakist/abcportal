<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Portal | Single Thread</title>
</head>
<body>

<s:iterator value="threadDataList">
			<div class="">
				<p><s:property value="thr_id"/>.&nbsp;Thread Subject:&nbsp;<s:property value="thr_subject" /></p>
			</div>
			<form action="manage-threads.action?submitType=postThreadMessage&thr_id=<s:property value="thr_id"/>" method="POST">
				
				<input type="text" name="thr_msg_text"class="form-control" />
				<input type="submit" value="post message" class="btn btn-info" />
			</form>
		</s:iterator> 
<!-- check if thread has messages -->
		<s:if test="threadMessageList.isEmpty()">
			<p>This thread is currently empty :(</p>
			<p>Write a message!</p>
		</s:if>
		<!-- if thread has messages, display them via this table -->
		<s:else>
			<table>
				<tr>
					<th>Id</th>
					<th>Message</th>
					<th>Thread_id</th>
				</tr>
					<s:iterator value="threadMessageList">
					
						<tr>
							<td><s:property value="thr_msg_id"/></td>
							<td><s:property value="thr_msg_text"/></td>
							<td><s:property value="thr_id" /></td>
						</tr>
				</s:iterator>
				
				
			</table>
		</s:else>
<a href="manage-threads.action?submitType=viewAll">Go Back to Thread Listing</a>
</body>
</html>