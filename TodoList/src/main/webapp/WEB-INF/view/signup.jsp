<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-DO</title>
<script src="js/SignupValidations.js"></script>
<link rel="stylesheet" href="/css/signup.css">
</head>
<body>
<nav>
<h1>TodoList</h1>
</nav>
<main>
	<div class="signupForm">
		<h2>Sign Up</h2>
		<f:form action="signup" modelAttribute="userDetails" onsubmit="return passwordsMatch()">
			<table>
				<tr>
					<td>Name: </td>
					<td><f:input path="name" placeholder = "Name" /></td>
				</tr>
				<tr>
					<td>Mobile No.: </td>
					<td><f:input path="mobileNo" placeholder="Mobile" name = "mobileNo"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><f:input path="email"  type="email"  placeholder= "Email"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><f:input path="password" type="password" name="password" id="password" placeholder="Password" /></td>
				</tr>
				<tr>
					<td>Confirm Password: </td>
					<td><input type="password" name = "rePassword" id = "rePassword" placeholder = "retype Password"/></td>
				</tr>
			</table>
			<div class="submitContainer">
				<input type="submit" value="Sign Up" class = "addButton"/>
			</div>
		</f:form>
	</div>
	<br>
	<a href="/login">Already User?</a>
</main>
</body>
</html>