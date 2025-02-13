<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
</head>
<body>
	<div class="header">
		<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
	</div>
	<div class="contents">
		<nav class="nav">
			<ul class="contents_top">
				<li><a href="/products/list.do">홈으로</a></li>
				<li><a href="/products/list.do">My Page</a></li>
				<li><a href="/products/add.do">상품 조회</a></li>
			</ul>

		</nav>


	</div>
	<div class="contents_main">
		<form action="./update.do" method="post">
			<h3>Email : 
				<input type="text" name="email" value="${user.email}">
			</h3>
			<br>
			<h3>Name : 
				<input type="text" name="name" value="${user.name }">
			</h3>
			<br>
			<h3>Phone : 
				<input type="text" name="phone" value="${user.phone }">
			</h3>
			<br>
			<button type="submit">수정하기</button>
		</form>
	</div>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>