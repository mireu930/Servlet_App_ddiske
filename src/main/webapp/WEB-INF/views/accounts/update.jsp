<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "./detail.do" method = "post">
		<input type="text" name ="accountNum" value = "${dto.accountNum}" readonly>
		<input type="text" name ="productNum" value = "${dto.productNum}">
		<input type="text" name ="user_name" value = "${dto.user_name}">
		<input type="text" name ="accountsBalance" value = "${dto.accountsBalance}">
		<input type="text" name ="accountDate" value = "${dto.accountDate}">
		<input type = "submit" value = "수정">
	</form>
</body>
</html>