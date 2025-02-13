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
	<h3>시작</h3>
	<c:if test="${empty user}">
		<a href ="/users/login.do">로그인</a>
		<a href ="/users/join.do">사원등록</a>
	</c:if>
	<c:if test="${not empty user}">
		<a href ="/users/logout.do">로그아웃</a>
		<a href ="/users/mypage.do">마이페이지</a>
	</c:if>
	
	<a href = "/products/list.do">상품</a>
	<a href = "/accounts/list.do">계좌</a>
</body>
</html>