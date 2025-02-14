<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "./update.do" method = "post">
		<input type="text" name ="user_name" value = "${user.user_name}">
		<input type="password" name ="password" value = "${user.password}">
		<input type="text" name ="name" value = "${user.name}">
		<input type="text" name ="phone" value = "${user.phone}">
		<input type="text" name ="email" value = "${user.email}">
		<input type = "submit" value = "수정">
	</form>
</body>
</html>