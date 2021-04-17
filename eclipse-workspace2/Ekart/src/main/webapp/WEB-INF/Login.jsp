<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form method="POST" action="login">
		<div name="login_blk">
			<div name="uname_blk">
				<label for="username">UserName</label> <input type="text"
					name="username" id="username">
			</div>
			<div name="passwd_blk">
				<label for="password">Password</label> <input type="password"
					name="password" id="password">
			</div>
			<div name="login_blk">
				<button type="submit" name="login" id="login">Log in</button>
			</div>

		</div>
	</form>
</body>
</html>