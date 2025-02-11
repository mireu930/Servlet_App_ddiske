<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
DepartmentDAO dao = new DepartmentDAO();
List<DepartmentDTO> ar = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../template/common.jsp"%>
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
	<%@ include file="../template/header.jsp"%>
	<section class="wrap_left content">
		<%@ include file="../template/nav.jsp"%>
		<nav class=" right content_right">
			<table>
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서명</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < ar.size(); i++) {
					%>
					<tr>
						<td><a
							href="departmentDetail.do?department_id=<%=ar.get(i).getDepartment_id()%>"><%=ar.get(i).getDepartment_id()%></a></td>
						<td><%=ar.get(i).getDepartment_name()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<div> 
				요청하신 정보를 찾을수 없습니다.
				<a href = /index.do>home</a>
			</div>
		</nav>
	</section>
	<%@ include file="../template/footer.jsp"%>
</body>
</html>