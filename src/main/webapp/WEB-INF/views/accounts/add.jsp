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
	<form action = "add.do" method = "post">
		<input type = "text" name = "productNum" placeholder="상품번호">
		<input type = "text" name = "user_name" placeholder="유저이름">
		<input type = "submit" value = "등록">
	</form>
</body>
</html>