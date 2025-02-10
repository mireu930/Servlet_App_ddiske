<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	DepartmentDAO dao = new DepartmentDAO();
	String name = request.getParameter("department_name");
	String id = request.getParameter("manager_id");
	
	DepartmentDTO dto = new DepartmentDTO();
	dto.setDepartment_name(name);
	dto.setManager_id(Long.parseLong(id));
	
	int result = dao.add(dto);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 등록 진행</h1>
	<%if(result > 0) {%>
		추가되었습니다.
	<% }else { %>
		실패했습니다.
	<%} %>
	<a href = "/">Home</a>
		<a href = "./departmnetList.jsp">부서리스트</a>
</body>
</html>