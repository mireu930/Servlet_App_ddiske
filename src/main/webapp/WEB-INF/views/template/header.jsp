<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="wrap_left">
	<div class="left logo">
		<img src="/resources/images/네이버.svg">
	</div>
	<div class="right menu">
		<ul>
			<c:if test="${empty user}">
			<li><a href="/employee/login.do">로그인</a></li>
			<li><a href="/employee/join.do">사원등록</a></li>
			</c:if>
			
			<c:if test="${not empty user}">
			<li><a href="/employee/logout.do">로그아웃</a></li>
			<li><a href="/employee/mypage.do">마이페이지</a></li>
			</c:if>
		</ul>
	</div>
</header>
