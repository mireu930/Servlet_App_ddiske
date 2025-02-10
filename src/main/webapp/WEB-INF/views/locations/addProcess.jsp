<%@page import="com.root.app.locations.LocationDAO"%>
<%@page import="com.root.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDTO locationDTO = new LocationDTO();
	locationDTO.setCity(request.getParameter("city"));
	locationDTO.setCountry_id(request.getParameter("country_id"));
	locationDTO.setPostal_code(request.getParameter("postal_code"));
	locationDTO.setState_province(request.getParameter("state_province"));
	locationDTO.setStreet_address(request.getParameter("street_address"));
	LocationDAO locationDAO = new LocationDAO();
	int result = locationDAO.add(locationDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result > 0) { %>
		<h3>등록 완료</h3>
	<%}else { %>
		<h4>등록 실패</h4>
	<%} %>
	<a href="/">Home</a>
	<a href="./list.jsp">지역 리스트</a>
</body>
</html>