<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/register">
		<div name="login_blk">
			<div name="uname_blk">
				<label for="username">UserName</label> <input type="text"
					name="username" id="username">
			</div>
			<div name="passwd_blk">
				<label for="password">Password</label> <input type="password"
					name="password" id="password">
			</div>
			<div name="cnf_blk">
				<label for="confirm">Confirm</label> <input type="password"
					name="confirm" id="confirm">
			</div>
			<div name="mail_blk">
				<label for="email">E-mail</label> <input type="email" name="email"
					id="email">
			</div>
			<div name="register_blk">
				<button type="submit" name="register" id="register">Register</button>
			</div>
	</form>
</body>
</html>