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
				<li><a href="/index.do">홈으로</a></li>
				<li><a href="/products/list.do">상품 둘러보기</a></li>
				<li><a href="/users/update.do">정보 수정</a></li>
				<li><a href="#">가입 내역 보기</a></li>
			</ul>

		</nav>


	</div>
	<div class="contents_main">
		<div class="contents_detail">
			<h3>Username : ${sessionScope.user.userName }</h3>
			<br>
			<h3>Name : ${sessionScope.user.name }</h3>
			<br>
			<h3>Phone : ${sessionScope.user.phone }</h3>
			<br>
			<h3>Email : ${sessionScope.user.email }</h3>
			<br>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>