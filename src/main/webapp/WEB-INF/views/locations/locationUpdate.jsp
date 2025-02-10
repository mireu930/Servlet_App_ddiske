<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = request.getParameter("location_id");
    	LocationDAO locationDAO = new LocationDAO();
    	LocationDTO locationDTO = new LocationDTO();
    	
    	locationDTO.setLocation_id(Integer.parseInt(id));
    	locationDTO = locationDAO.getDetail(locationDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "./locationUpdateProcess.jsp" method = "post">
		<input type = "hidden" name = "location_id" value = "<%= locationDTO.getLocation_id()%>">
		<input type = "text" name = "streeat_address" value = "<%=locationDTO.getStreet_address() %>">
		<input type = "text" name = "postal_code" value = "<%= locationDTO.getPostal_code()%>">
		
		<input type = "submit" value= "수정">
	</form>
	
</body>
</html>