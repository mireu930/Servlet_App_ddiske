<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="../resources/css/add.css">
</head>
<body>
	<form action = "./update.do" method = "post">
		아이디<input type="text" name ="user_name" value = "${user.user_name}">
		비밀번호<input type="password" name ="password" value = "${user.password}">
		이름<input type="text" name ="name" value = "${user.name}">
		전화번호<input type="text" name ="phone" value = "${user.phone}">
		이메일<input type="text" name ="email" value = "${user.email}">
		<input type = "submit" value = "수정">
	</form>
</body>
</html>