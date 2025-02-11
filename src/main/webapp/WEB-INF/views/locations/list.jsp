<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/common.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
	<section class="contents wrap_left">
		<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
		<div class="contents_right right">
			<!-- contents 내용 기술 -->
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>지역번호</th>
							<th>도시명</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${pageScope.dto.location_id }</td>
								<td><a href="./detail.do?location_id=${pageScope.dto.location_id }%>">
										${pageScope.dto.city }</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<a href="./add.do">추가</a>
		</div>
	</section>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>