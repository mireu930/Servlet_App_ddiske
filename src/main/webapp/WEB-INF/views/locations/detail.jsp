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
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
	<section class="contents wrap_left">
		<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
		<div class="contents_right right">
			<!-- contents 내용 기술 -->
			<h1>Location Detail Page</h1>
			<c:choose>
				<c:when test="${not empty dto }">
					<h3>${requestScope.dto.location_id }</h3>
					<h3>${requestScope.dto.city }</h3>
					<h3>${requestScope.dto.street_address }</h3>
					<h3>${requestScope.dto.postal_code }</h3>

					<a href="./update.do?location_id=${requestScope.dto.location_id }">수정하기</a>
					<a href="./delete.do?location_id=${requestScope.dto.location_id }">삭제</a>
				</c:when>
				<c:when test="${empty dto }">
					<h3>없는 지역</h3>
				</c:when>

			</c:choose>

		</div>
	</section>

	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>