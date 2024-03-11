<%@page import="com.seclore.todolist.domain.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TodoList</title>
</head>
<body>
	<%!
		UserDetails userDetails;
	%>
	<%
		userDetails = (UserDetails) session.getAttribute("loggedInUser");
	%>
	<nav>
		<ul>
			<li>
				<img src="" alt="Logo of user">
				<p><%=userDetails.getName() %></p>
			</li>
			<li>
				<h1>Todo List</h1>
			</li>
			<li>
				<a href="">Log out</a>
			</li>
		</ul>
	</nav>
	<main>
		<table>
			<thead>
				<th>ID</th>
				<th>Title</th>
				<th>Description</th>
				<th>Status</th>
				<th>Actions</th>				
			</thead>
			<tbody>
			<c:if test="${allTasks != null }">
				<c:forEach var="task" items="${allTasks}">
					<tr>
						<td>${task.taskId}</td>
						<td>${task.title}</td>
						<td>${task.description}</td>
						<td>${task.status }</td>
						<td>
							<div>
								<form action="/tasks/edit" method="get">
									<input type="hidden" value="${task.taskId }" name="taskId">
								</form>
								<form action="/tasks/delete" method="post">
									<input type="hidden" value="${task.taskId }" name="taskId">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${allTasks == null }">
				<h2>No Todo Available</h2>
			</c:if>
			</tbody>
		</table>			
	</main>
</body>
</html>