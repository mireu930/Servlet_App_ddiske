<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Sementic tag -->
<header class="wrap_left">
	<div class="logo left">
		<img src="../resources/images/logo_60x29.png">
	</div>
	<div class="menu right">
		<ul>
		<c:if test="${empty user }">
			<li><a href="/employees/login.do">로그인</a></li>
			<li><a href="/employees/join.do">사원 등록</a></li>			
		</c:if>
		<c:if test="${not empty user }">
			<li><a href="/employees/logout.do">로그아웃</a></li>
			<li><a href="/employees/mypage.do">My page</a></li>
		</c:if>
		</ul>
	</div>
</header>
