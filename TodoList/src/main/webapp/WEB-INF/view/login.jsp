<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/login.css">
<title>Login</title>
</head>
<body>
	<%!
		String message;
		String messageClass;
	%>
	<%message = (String) session.getAttribute("message"); 
	
	if(message != null){
		if(message.contains("Successfully")){
			messageClass = "message added";
		}else{
			messageClass = "message error";
		}	
	}
	%>

	<nav>
		<h1>TodoList</h1>
	</nav>
	<main>
		<div class="loginForm">
			<h2>Login</h2>

			<form:form action="userlogin" modelAttribute="userDetails">
				<table>
					<tr>
						<td>Email Id</td>
						<td><form:input path="email" type="email" placeholder="Email" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input path="password" type="password"
								placeholder="Password" /></td>
					</tr>
				</table>
				<div class="submitContainer">
					<td><input class="addButton" type="submit" value="Login"></td>
				</div>
				<br>
			</form:form>
						<c:if test="${message != null}">
				<div class="<%=messageClass %>">
					<p>${message}</p>
				</div>
				<%
				session.removeAttribute("message");
				%>
			</c:if>
		</div>
		<br>
		<p>
			<a href="signup">New User?</a>
		</p>
	</main>
</body>
</html>