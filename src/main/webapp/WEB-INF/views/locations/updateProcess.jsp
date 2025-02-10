<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDAO locationDAO = new LocationDAO();
	LocationDTO locationDTO = new LocationDTO();
	locationDTO.setCity(request.getParameter("city"));
	locationDTO.setCountry_id(request.getParameter("country_id"));
	locationDTO.setPostal_code(request.getParameter("postal_code"));
	locationDTO.setState_province(request.getParameter("state_province"));
	locationDTO.setStreet_address(request.getParameter("street_address"));
	locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
	int result = locationDAO.update(locationDTO);
	
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