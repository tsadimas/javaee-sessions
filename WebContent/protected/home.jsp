<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>

	<h3>Hi ${User.name}</h3>
	<strong>Your Email</strong>: ${User.email}
	<br>
	<strong>Your Country</strong>: ${User.country}
	<br>
	<br>
	<form action="${pageContext.request.contextPath}/Logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>