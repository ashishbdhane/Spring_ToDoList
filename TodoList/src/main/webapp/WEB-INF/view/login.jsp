<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
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
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="login"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>