<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	// 스크립틀릿 자바코드 안에 사용하는
	DepartmentDAO departmentDAO = new DepartmentDAO();
	List<DepartmentDTO> ar = departmentDAO.getList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
	border: 1px solid black;
	margin: 0 auto;
	width: 50%;
	}
	table tr, td, th {
	border: 1px solid black;
	}
</style>
</head>
<body>
	<h1>Department list</h1>
	<h3>표현식 : 자바의 변수나 값을 html로 출력할 때 사용</h3>
	<table>
		<thead>
			<tr>
				<th>부서번호</th><th>부서명</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i = 0; i < ar.size(); i++) {%>
			<tr>
				<td><%= ar.get(i).getDepartment_id()%></td>
				<td>
					<a href="./detail.jsp?department_id=<%=ar.get(i).getDepartment_id()%>">
						<%= ar.get(i).getDepartment_name()%>
					</a>
				</td>
			</tr>
		<%}%>
		</tbody>
		
	</table>
	
	<div>
		<a href="./add.jsp">부서등록</a>
	</div>
</body>
</html>