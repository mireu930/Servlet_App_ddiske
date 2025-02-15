<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/add.css">
</head>
<body>
	<form action="login.do" method = "post">
		<fieldset>
			<legend>아이디</legend>
			<input type ="text" name = "user_name">
		</fieldset>
		<fieldset>
			<legend>비밀번호</legend>
			<input type ="password" name = "password">
		</fieldset>
		<fieldset>
			<input type ="submit" value = "로그인">
		</fieldset>
		
	</form>
	<a href ="../index.do">홈</a>
</body>
</html>