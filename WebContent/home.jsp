<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login with UserName & Password</h1>
	<form:form id="loginForm" action="j_spring_security_check"
		method="post">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="j_username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>

		</table>

	</form:form>


	<%--  ${register} --%>
</body>
</html>