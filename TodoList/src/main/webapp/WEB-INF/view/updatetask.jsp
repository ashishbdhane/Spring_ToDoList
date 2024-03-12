<%@page import="com.seclore.todolist.domain.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>
<link rel="stylesheet" href="/css/addedittask.css">
</head>
<body>
	<%!UserDetails userDetails;%>
	<%
		userDetails = (UserDetails) session.getAttribute("loggedInUser");
	%>
	<nav>
		<ul class="navList">
			<li class="userDetails">
				<img class="userLogo" src="/img/user.png" alt="Logo of user">
				<p><%=userDetails.getName()%></p>
			</li>
			<li>
				<h1>Todo List</h1>
			</li>
			<li><a href="/logout" class="logout">Log out</a></li>
		</ul>
	</nav>
	<main>
		<div class="updateForm">
			<h2>Update Task</h2>
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
				<div class="submitContainer">
					<input class="addButton editButton" type="submit" value="Update Task">
				</div>
			</form:form>
		</div>
		<a class="backLink" href="/tasks"> Back to All Tasks</a>
	</main>
</body>
</html>