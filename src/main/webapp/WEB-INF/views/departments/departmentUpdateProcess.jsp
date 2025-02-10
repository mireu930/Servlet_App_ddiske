<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	DepartmentDTO departmentDTO = new DepartmentDTO();
    	DepartmentDAO departmentDAO = new DepartmentDAO();
    	
    	String id = request.getParameter("department_id");
    	departmentDTO.setDepartment_id(Long.parseLong(id));
    	departmentDTO = departmentDAO.getDetail(departmentDTO);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="./departmentUpdate.jsp" method ="post">
		<input type ="hidden" name = "department_id" value = "<%= departmentDTO.getDepartment_id()%>">
		부서<input type = "text" name ="department_name" value = "<%= departmentDTO.getDepartment_name()%>"><br>
		매니저id<input type = "text" name ="manager_id" value = "<%= departmentDTO.getManager_id()%>"><br>
		지역id<input type = "text" name ="location_id" value = "<%= departmentDTO.getLocation_id()%>"><br>
		
		<input type = "submit" value = "수정">
	</form>
</body>
</html>