<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	//스크립툴릿 자바코드안에 사용하는 
	Object ar = request.getAttribute("list");
	List<DepartmentDTO> list = (List) ar;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
<%@ include file="../template/header.jsp" %>
  <section class = "wrap_left content">
    <%@ include file = "../template/nav.jsp" %>
    <nav class = " right content_right">
		<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=0;i<list.size();i++){%>
			<tr>
				<td><%= list.get(i).getDepartment_id()%></td>
				<td><a
					href="departmentDetail.do?department_id=<%= list.get(i).getDepartment_id()%>">
						<%= list.get(i).getDepartment_name()%></a></td>
			</tr>
			<%}%>
		</tbody>
		<tfoot>
			<tr>
				<td><a href="departmentAdd.jsp">부서등록</a></td>
			</tr>
		</tfoot>
	</table>
	
    </nav>
  </section>
  <%@ include file = "../template/footer.jsp" %>

	

</body>
</html>