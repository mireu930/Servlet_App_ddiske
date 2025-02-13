<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/add.css">
</head>
<body>
	<h3>사원등록</h3>
	<form action = "join.do" method = "post">
		<fieldset>
			<input type = "text" name = "user_name" placeholder="아이디">
		</fieldset>
		<fieldset>
			<input type = "password" name = "password" placeholder="비밀번호">
		</fieldset>
		<fieldset>
			<input type = "text" name = "name" placeholder="이름">
		</fieldset>
		<fieldset>
			<input type = "text" name = "phone" placeholder="전화번호">
		</fieldset>
		<fieldset>
			<input type = "text" name = "email" placeholder="이메일">
		</fieldset>
		<fieldset>
			<input type ="submit" value = "등록">
		</fieldset>
	</form>
</body>
</html>