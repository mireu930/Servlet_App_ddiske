<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    DepartmentDTO departmentDTO = new DepartmentDTO();
    DepartmentDAO departmentDAO = new DepartmentDAO();
    
    String id = request.getParameter("department_id");
    departmentDTO.setDepartment_id(Long.parseLong(id));
    
    int result = departmentDAO.delete(departmentDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result > 0) {%>
		<h3>부서삭제되었습니다.</h3>
	<%}else { %>
		<h3>실패하였습니다.</h3>
	<%} %>
	<a href = "/">Home</a>
	<a href = "./list.jsp">list</a>
</body>
</html>