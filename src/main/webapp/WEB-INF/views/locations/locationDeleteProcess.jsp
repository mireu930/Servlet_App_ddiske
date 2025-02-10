<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@page import="com.root.app.departments.DepartmentDTO"%>
<%@page import="com.root.app.departments.DepartmentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     LocationDAO locationDAO = new LocationDAO();
    LocationDTO locationDTO = new LocationDTO();
    
    String id = request.getParameter("location_id");
    locationDTO.setLocation_id(Integer.parseInt(id));
    
    int result = locationDAO.delete(locationDTO);
    
    String message = "실패";
    
    if(result>0){
    	message = "성공";	
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>삭제</h3>
	<%=message %>
	<a href = "/">Home</a>
	<a href = "./locationList.jsp">list</a>
</body>
</html>