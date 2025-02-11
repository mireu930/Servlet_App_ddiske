<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
  	<section class = "wrap_left content">
  	<c:import url="../template/nav.jsp"></c:import>
    <nav class = " right content_right">
		<table>
		<thead>
			<tr>
				<th>지역아이디</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">				
			<tr>
				<td><a
					href="locationDetail.do?location_id=${list.location_id}">
						${list.location_id}</a></td>
						<td>
							${list.street_address}</td>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td><a href="locationAdd.do">지역등록</a></td>
			</tr>
		</tfoot>
	</table>
	 </nav>
  </section>
  	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>