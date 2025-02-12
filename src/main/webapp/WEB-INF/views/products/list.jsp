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
		<h3><a href = "./detail.do?productNum=${ar.productNum}">${ar.productNum}</a></h3>
		<h3>${ar.productName}</h3>
		<h3>${ar.productDetail}</h3>
		<h3>${ar.productRate}</h3>
		<h3>${ar.productDate}</h3>
		<h3>----</h3>
	</c:forEach>
	
	<a href = "./add.do">등록</a>
</body>
</html>