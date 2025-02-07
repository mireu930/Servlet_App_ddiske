<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/reset.css">

<style>



	.top {
		width: 100%;
		height: 100px;
		background-color : grey;
		display: block;
	}

	.mid {
		width: 100%;
		height: 1080px;
		background-color: aqua;
		display: block;
	}

	.logo {
		width: 100px;
		height: 100px;
		background-color: greenyellow;
		float: inline-start;
	}

	.menu {
		width: 100px;
		height: 1080px;
		background-color: yellow;
		float: inline-start;
	}

	.bot {
		width: 100%;
		height: 360px;
		background-color: black;
		color: aliceblue;
	}

	.m1 {
		display: flex;
		float: inline-end;
		margin: 0 auto;
	}

	.m2 {
		list-style: disc;
	}
</style>

</head>
<body>
	<div class="top">
		<div class="logo">
			로고
		</div>
		상단메뉴
		<ul class="m1">
			<li>로그인</li>
			<li>회원가입</li>
		</ul>
	</div>
	<div class="mid">
		<div class="menu">
			<ul class="m2">
				<li>1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
			</ul>
		</div>
		중단내용
	</div>
	<div class="bot">
		하단내용
	</div>
</body>
</html>