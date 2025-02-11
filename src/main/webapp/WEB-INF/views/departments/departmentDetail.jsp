<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel = "stylesheet" href ="/resources/css/list.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, table th, table td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
td a {
	text-decoration: none;
	color: black;
}
</style>
</head>
<body>
	<h1>Department Detail Page</h1>
	<div>
	</div>
	<table>
	 <%-- <c:if test="${not empty requestScope.dto}"> --%>
	 <c:choose>
	 	<c:when test="${not empty dto}">
	 	
	 	</c:when>
	 	<c:otherwise>
	 	
	 	</c:otherwise>
	 </c:choose>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>매니저id</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.department_id}</td>
				<td>${dto.department_name}</td>
				<td>${dto.manager_id}</td>												
				<td><a href ="./departments/departmentDeleteProcess.do?department_id=${requestScope.dto.department_id}">삭제</a></td>
				<td><a href = "./departments/departmentUpdateProcess.do?department_id=${requestScope.dto.department_id}">수정</a></td>
				
		</tbody>
		<%-- </c:if> --%>
		<%-- <c:if test="${empty dto}">
			<h3>부서정보가없다</h3>
		</c:if> --%>
	</table>
</body>
</html>