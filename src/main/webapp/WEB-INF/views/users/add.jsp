<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 추가</h3>
	<form action = "join.do" method = "post">
		<input type = "text" name = "user_name" placeholder="아이디">
		<input type = "password" name = "password" placeholder="비밀번호">
		<input type = "text" name = "name" placeholder="이름">
		<input type = "text" name = "phone" placeholder="전화번호">
		<input type = "text" name = "email" placeholder="이메일">
		<input type = "submit" value = "등록">
	</form>
</body>
</html>