<%@page import="com.seclore.todolist.domain.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/alltasks.css">
<script defer type="text/javascript" src="/js/notification.js"></script>
<title>TodoList</title>
</head>
<body>
	<%!
		UserDetails userDetails;
		String message;
		String messageClass;
	%>
	<%
		userDetails = (UserDetails) session.getAttribute("loggedInUser");
		message = (String) session.getAttribute("message");
		if(message != null){
			if(message.equals("Task Added")){
				messageClass = "message added";
			}else if(message.equals("Task Edited")){
				messageClass = "message edited";
			}else{
				messageClass = "message deleted";
			}	
		}
		
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
		<c:if test="${message != null}">
			<div class="<%=messageClass %>" >
				<p>${message }</p>
			</div>
			<% session.removeAttribute("message"); %>
		</c:if>
		<c:if test="${allTasks == null || allTasks.isEmpty() == true }">
			<h2 class="noTodoAvailable">No Todo Available</h2>
		</c:if>
		<form class="addForm" action="/tasks/add" method="get">
			<input class="addButton" type="submit" value="Add" name="addTask">
		</form>
		<c:if test="${allTasks != null && allTasks.isEmpty() == false }">
			<table>
				<thead>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Status</th>
					<th>Actions</th>
				</thead>
				<tbody>

					<c:forEach var="task" items="${allTasks}">
						<tr class="${task.status }">
							<td>${task.taskId}</td>
							<td>${task.title}</td>
							<td>${task.description}</td>
							<td>${task.status }</td>
							<td>
								<div class="actions">
									<form action="/tasks/edit" method="get">
										<input type="hidden" value="${task.taskId }" name="taskId">
										<input class="addButton editButton" type="submit" value="Edit" name="editTask">
									</form>
									<form action="/tasks/delete" method="post">
										<input type="hidden" value="${task.taskId }" name="taskId">
										<input class="addButton deleteButton" type="submit" value="Delete" name="deleteTask">
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</main>
</body>
</html>