<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href ="../resources/css/add.css">
</head>
<body>
	<form action = "./update.do" method = "post">
		<input type="text" name ="productNum" value = "${dto.productNum}" readonly>
		<input type="text" name ="productName" value = "${dto.productName}">
		<input type="text" name ="productDetail" value = "${dto.productDetail}">
		<input type="text" name ="productRate" value = "${dto.productRate}">
		<input type="text" name ="productDate" value = "${dto.productDate}">
		<input type = "submit" value = "수정">
	</form>
</body>
</html>