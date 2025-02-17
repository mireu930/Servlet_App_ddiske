<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
	<c:if test="${not empty user}">
	<table>
			<tr>
				<td>아이디</td>
				<td>${user.user_name}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${user.password}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${user.phone}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td><a href = "./update.do?user_name=${user.user_name}">수정</a></td>
				<td></td>
			</tr>
	</table>
	<a href ="../index.do">홈</a>
	</c:if>
	
	<c:if test="${empty user}">
		<h3>정보가 없습니다.</h3>
	</c:if>
	
</body>
</html>