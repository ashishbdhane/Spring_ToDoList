<%@page import="com.seclore.todolist.domain.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
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
			<h2>Add Task</h2>
			<form:form action="/tasks/add" method="post" modelAttribute="taskDetails">
				<table>
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
					<input class="addButton editButton" type="submit" value="Add Task">
				</div>
			</form:form>
		</div>
		<a class="backLink" href="/tasks"> Back to All Tasks</a>
	</main>
</body>
</html>