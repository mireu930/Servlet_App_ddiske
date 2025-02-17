<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/button.css">
<link rel="stylesheet" href="/resources/css/inputForm.css">
</head>
<body>
	<div class="header">
		<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
	</div>
	<section class="contents">
		<nav class="nav">
			<ul class="contents_top">
				<li><a href="/index.do">홈으로</a></li>
			</ul>
		</nav>
	</section>

	<div class="contents_main">
		<div class="in_box">
			<form class="add_input" action="./login.do" method="post">
				<div class="title">로그인</div>
				<div class="subtitle">ID, PW 입력하기</div>
				<fieldset class="input-container ic1">
					<!-- <legend>ID</legend> -->
					<input type="text" name="username" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="ID" class="placeholder">ID</label>
				</fieldset>
				<fieldset class="input-container ic2">
					<!-- <legend>PASSWORD</legend> -->
					<input type="password" name="password" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="PASSWORD" class="placeholder">PASSWORD</label>
				</fieldset>

				<div class="button_container">
					<button class="btn">
						<span>Log-in</span>
					</button>
				</div>
			</form>
		</div>
	</div>

	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>