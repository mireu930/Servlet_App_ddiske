<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
지역등록하기
<form action="./locationAddProcess.jsp" method ="post">
	지역주소<input type = "text" name = "street_addess">
	우편번호<input type = "text" name = "postal_code">
	city<input type = "text" name = "city">
	<input type = "submit" value = "등록" >
</form>
</body>
</html>