<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-DO</title>
</head>
<body>
	<h2>Sign Up</h2>

	<f:form action="signup" modelAttribute="user">
		<table>
			<tr>
				<td>Login Id:</td>
				<td><f:input path="userId" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><f:input path="name" /></td>
			</tr>
			<tr>
				<td>Mobile No.:</td>
				<td><f:input path="mobileNo" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><f:input path="email" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><f:input path="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><f:input path="password" /></td>
			</tr>
		</table>
		<input type="submit" value="login" />
	</f:form>
	<a href="/login">Already User?</a>
</body>
</html>