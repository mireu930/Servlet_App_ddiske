<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	LocationDAO dao = new LocationDAO();
    	LocationDTO locationDTO = new LocationDTO();
    	
    	String address = request.getParameter("street_address");
    	String code = request.getParameter("postal_code");
    	String city = request.getParameter("city");
    	
    	locationDTO.setStreet_address(address);
    	locationDTO.setPostal_code(code);
    	locationDTO.setCity(city);
    
    	int result = dao.add(locationDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(result > 0) {%>
	추가되었습니다.
	<%}else{ %>
	실패했습니다.
	<%} %>
	<h3><a href = "/">home</a></h3>
	<h3><a href = "./locationList.jsp">지역리스트</a></h3>
</body>
</html>