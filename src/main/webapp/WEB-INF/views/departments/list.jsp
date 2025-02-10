<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// 스크립틀릿 자바코드 안에 사용하는
// DepartmentDAO departmentDAO = new DepartmentDAO();
// List<DepartmentDTO> ar = departmentDAO.getList();
	Object list = request.getAttribute("list");
	List<DepartmentDTO> ar = (List<DepartmentDTO>)list;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../template/common.jsp"%>
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
	<%@include file="../template/header.jsp"%>
	<section class="contents wrap_left">
		<%@include file="../template/nav.jsp"%>
		<div class="contents_right right">
		<div class="contents_right_list">
			<table class="table_sprite">
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
						<td><%=ar.get(i).getDepartment_id()%></td>
						<td><a
							href="./detail.do?department_id=<%=ar.get(i).getDepartment_id()%>">
								<%=ar.get(i).getDepartment_name()%>
						</a></td>
					</tr>
					<%
					}
					%>
				</tbody>

			</table>
			</div>

			<div>
				<a href="./add.do">부서등록</a>
			</div>

		</div>

	</section>
	<%@include file="../template/footer.jsp"%>

</body>
</html>