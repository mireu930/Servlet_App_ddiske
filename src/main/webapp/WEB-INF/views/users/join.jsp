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
	<div class="contents">
		<nav class="nav">
			<ul class="contents_top">
				<li><a href="/index.do">홈으로</a></li>
			</ul>
		</nav>


	</div>
	<div class="contents_main">
		<div class="in_box">
			<form class="add_input" action="./join.do" method="post">
				<div class="title">회원가입</div>
				<div class="subtitle">정보 입력</div>
				<fieldset class="input-container ic1">
					<legend>ID</legend>
					<input type="text" name="username" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="ID" class="placeholder">ID</label>
				</fieldset>
				<fieldset class="input-container ic2">
					<legend>PASSWORD</legend>
					<input type="password" name="password" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="PASSWORD" class="placeholder">PASSWORD</label>
				</fieldset>
				<fieldset class="input-container ic3">
					<legend>NAME</legend>
					<input type="text" name="name" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="NAME" class="placeholder">NAME</label>
				</fieldset>
				<fieldset class="input-container ic4">
					<legend>PHONE</legend>
					<input type="text" name="phone" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="PHONE" class="placeholder">PHONE</label>
				</fieldset>
				<fieldset class="input-container ic5">
					<legend>EMAIL</legend>
					<input type="text" name="email" class="input" placeholder=" ">
					<div class="cut"></div>
					<label for="EMAIL" class="placeholder">EMAIL</label>
				</fieldset>

				<div class="button_container">
					<button class="btn">
						<span>Join</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>