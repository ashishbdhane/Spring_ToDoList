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
	<h2>Sign Up</h2>

	<f:form action="signup" modelAttribute="userDetails" onsubmit="return passwordsMatch()">
		<table>
			<tr>
				<td>Name: </td>
				<td><f:input path="name" placeholder = "Name" /></td>
			</tr>
			<tr>
				<td>Mobile No.: </td>
				<td><f:input path="mobileNo" placeholder="Mobile" /></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><f:input path="email"  type="email"  placeholder= "Email"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><f:input path="password" type="password" id="password" placeholder="Password" /></td>
			</tr>
			<tr>
				<td>Confirm Password: </td>
				<td><input type="password" id= "rePassword" placeholder = "retype Password"/></td>
			</tr>
		</table>
		
		<input type="submit" value="Sign Up" class = "submit-btn"/>
	</f:form>
	<br>
	<a href="/login">Already User?</a>
</body>
</html>