<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@
 taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/common.jsp"></c:import>
<style>
table {
	margin: 0 auto;
	border-collapse: collapse;
	width: 100%;
	color:white;
}

thead {
	background-color: purple;
}

thead tr {
	border-top: 1px solid white;
	border-bottom: 2px solid white;
}

table td, table th {
	padding: 10px 20px;
	font-weight: bold;
}

tbody tr:nth-child(even) {
	 background-color: #2e2649;
}

tbody tr:nth-child(odd) {
	background-color: #423b5b;
}

tbody tr {
	text-align: center;
}


</style>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="wrap_left content">
		<c:import url="../template/nav.jsp"></c:import>
		<nav class=" right content_right">
			<table>
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서명</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="ar">
					<tr>
						<td><a
							href="departmentDetail.jsp?department_id=${ar.department_id }">${ar.deparment_id}</a></td>
						<td>${ar.department_name}</td>
						
					</tr>
				</c:forEach>
					

				</tbody>
			</table>
		</nav>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>