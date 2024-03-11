<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>
<style type="text/css">
	body{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	
	form{
		padding: 2rem;
		border: 1px solid black;
	}
	
	td{
		padding-bottom: 15px;
	}
	
	.submit{
		display: flex;
		justify-content: center;
		padding-top : 25px;
	}
	.title-div{
		width: 100%;
		display: grid;
		grid-template-columns: 1fr 1fr 1fr;
		grid-template-rows: 1fr;
		align-items: center;
		justify-items: center;
	}
</style>
</head>
<body>
	<div class="title-div">
		<a href="/tasks/"> Back to All Tasks</a>
		<h1>Update Task</h1>
	</div>
	<form:form action="/tasks/edit" method="post" modelAttribute="taskDetails">
		<table>
			<form:input path="taskId" type="hidden" value="${taskDetails.taskId}" />
			<tr>
				<td>Title : </td>
				<td><form:input path="title" type="text" required="required"/></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><form:textarea path="description" id="description"></form:textarea></td>
			</tr>
			<tr>
				<td>Status : </td>
				<td>
					<form:select path="status" items="${allStatus }" id="status" name="status">
    				</form:select>
				</td>
			</tr>
		</table>
		<div class="submit">
			<input type="submit" value="Update Task">
		</div>
	</form:form>
</body>
</html>