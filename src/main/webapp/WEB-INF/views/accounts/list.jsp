<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="ar">
		<h3><a href = "./detail.do?accountNum=${ar.accountNum}">${ar.accountNum}</a></h3>
		<h3>${ar.productNum}</h3>
		<h3>${ar.user_name}</h3>
		<h3>${ar.accountsBalance}</h3>
		<h3>${ar.accountDate}</h3>
		<h3>----</h3>
	</c:forEach>
	
	<a href = "./add.do">등록</a>
</body>
</html>