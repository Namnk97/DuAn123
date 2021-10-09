<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Index</title>
</head>
<body>
	<h1>Index</h1>
	<h4>Email: ${sessionScope.user}</h4>
	<form action="/Duan123/Login-out" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>