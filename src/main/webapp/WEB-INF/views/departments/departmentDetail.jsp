<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	DepartmentDTO departmentDTO = (DepartmentDTO)request.getAttribute("dto");
%>
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
	<%if (departmentDTO != null) {%>
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
				<td><%=departmentDTO.getDepartment_id()%></td>
				<td><%=departmentDTO.getDepartment_name()%></td>
				<td><%=departmentDTO.getManager_id()%></td>												
				<td><a href ="./departments/departmentDeleteProcess.do?department_id=<%= departmentDTO.getDepartment_id()%>">삭제</a></td>
				<td><a href = "./departments/departmentUpdateProcess.do?department_id=<%= departmentDTO.getDepartment_id()%>">수정</a></td>
				<%} else {%>
				없는부서입니다.
				<%}%>
		</tbody>
	</table>
</body>
</html>