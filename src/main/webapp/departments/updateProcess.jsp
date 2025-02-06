<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	DepartmentDTO departmentDTO = new DepartmentDTO();
	DepartmentDAO departmentDAO = new DepartmentDAO();
	departmentDTO.setDepartment_id(Long.parseLong(request.getParameter("department_id")));
	departmentDTO.setDepartment_name(request.getParameter("department_name"));
	departmentDTO.setManager_id(Long.parseLong(request.getParameter("manager_id")));
	departmentDTO.setLocation_id(Long.parseLong(request.getParameter("location_id")));
	int result = departmentDAO.update(departmentDTO);
	
	String r = "실패";
	if(result > 0) {
		r = "수정 완료";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=r %></h3>
	<a href="/">Home</a>
	<a href="./list.jsp">List</a>
</body>
</html>