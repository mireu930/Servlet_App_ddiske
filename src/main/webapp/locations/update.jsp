<%@page import="com.root.app.locations.LocationDAO"%>
<%@page import="com.root.app.locations.LocationDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDTO locationDTO = new LocationDTO();
	LocationDAO locationDAO = new LocationDAO();
	locationDTO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
	locationDTO = locationDAO.getDetail(locationDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Location Update Page</h1>
	<form action="./updateProcess.jsp" method="post">
		<input type="hidden" name="location_id" value="<%= locationDTO.getLocation_id() %>">
		지역 : <input type="text" name="state_province" value="<%=locationDTO.getState_province()%>"><br>
		도시 : <input type="text" name="city" value="<%=locationDTO.getCity()%>"><br>
		우편번호 : <input type="text" name="postal_code" value="<%=locationDTO.getPostal_code()%>"><br>
		주소 : <input type="text" name="street_address" value="<%=locationDTO.getStreet_address()%>"><br>
		국가코드 : <input type="text" name="country_id" value="<%=locationDTO.getCountry_id()%>"><br>
		<button type="submit">수정하기</button>
	</form>

</body>
</html>