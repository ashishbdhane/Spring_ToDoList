<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add TASK</title>
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
		<h1>Add Task</h1>
	</div>
	<form:form action="/tasks/add" method="post" modelAttribute="taskDetails">
		<table>
			<tr>
				<td> Add Title:  </td>
				<td><form:input path="title" type="text"  required="required"/></td>
			</tr>
			<tr>
				<td>Add Description: </td>
				<td><form:input path="Description" type="text"  required="required"/></td>
			</tr>
			<tr>
				<tr>
				<td>Status : </td>
				<td>
					<form:select path="status" items="${allStatus }" id="status" name="status">
    				</form:select>
				</td>
			</tr>
			</tr>
		</table>
		<div class="submit">
			<input type="submit" value="Add Task">
		</div>
	</form:form>
</body>
</html>