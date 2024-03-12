<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/css/login.css">
<title>Login</title>
</head>
<body>
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
					<td><form:input path="email" type="email" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="password" type="password" /></td>
				</tr>
			</table>
			<div class="submitContainer">
						<input class="addButton" type="submit" value="Login"></td>
			</div>
			<br>
		</form:form>
	</div>
	<br>
	<p>Not a User? then <a href="signup">Sign Up</a></p>
</main>
</body>
</html>