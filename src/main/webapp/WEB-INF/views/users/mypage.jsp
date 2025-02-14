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
	<c:if test="${not empty user}">
		<h3>${user.user_name}</h3>
		<h3>${user.password}</h3>
		<h3>${user.name}</h3>
		<h3>${user.phone}</h3>
		<h3>${user.email}</h3>
	</c:if>
	
	<c:if test="${empty user}">
		<h3>정보가 없습니다.</h3>
	</c:if>
	
	<a href = "./update.do?user_name=${user.user_name}">수정</a>
</body>
</html>