<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
	<div class="header">
		<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
	</div>
	<div class="contents">
		<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
	</div>

	<div class="contents_main">
		<div class="contents_main_list">
			<table class="table_sprite">
				<thead>
					<tr>
						<th>상품 번호</th>
						<th>상품명</th>
						<th>상품 이율</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${pageScope.dto.productNum }</td>
							<td><a href="./detail.do?productnum=${pageScope.dto.productNum }">${pageScope.dto.productName }</a></td>
							<td>${pageScope.dto.productRate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>