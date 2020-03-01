<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
<form action="LogIn">
	<div>
		<label for="email">Username</label>
		<input id="email" name="email" type="text"/>
	</div>
	<div>
		<label for="password">Password</label>
		<input id="password" name="password" type="password"/>
	</div>
	<div>
		<button id="login" name="login" type="submit">LogIn </button>
	</div>
	<br><br>
	<a href="SignUp">Don't have an account?</a>
</form>
</body>
</html>