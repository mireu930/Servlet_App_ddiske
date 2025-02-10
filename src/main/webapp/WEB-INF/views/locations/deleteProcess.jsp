<%@page import="com.root.app.locations.LocationDAO"%>
<%@page import="com.root.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDTO locationDTO = new LocationDTO();
	locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
	LocationDAO locationDAO = new LocationDAO();
	int result = locationDAO.delete(locationDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%if(result > 0) { %>
		<h3>삭제 완료</h3>
	<%}else { %>
		<h3>실패</h3>
	<%} %>
	
	<a href="/">Home</a>
	<a href="./list.jsp">List</a>
	
</body>
</html>