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
	<c:if test="${not empty dto}">
		<h3>${dto.productNum}</h3>
		<h3>${dto.productName}</h3>
		<h3>${dto.productDetail}</h3>
		<h3>${dto.productRate}</h3>
		<h3>${dto.productDate}</h3>
	</c:if>
	
	<c:if test="${empty dto}">
		<h3>정보가 없습니다.</h3>
	</c:if>
	
	<a href = "./update.do?productNum=${dto.productNum}">수정</a>
</body>
</html>