<%@page import="com.root.app.locations.LocationDAO"%>
<%@page import="com.root.app.locations.LocationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDTO locationDTO = (LocationDTO)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/template/common.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/views/template/header.jsp"%>

	<section class="contents wrap_left">
		<%@include file="/WEB-INF/views/template/nav.jsp"%>
		<div class="contents_right right">
			<!-- contents 내용 기술 -->
			<h1>Location Detail Page</h1>
	<%if(locationDTO != null) { %>
		<h3><%= locationDTO.getLocation_id() %></h3>
		<h3><%= locationDTO.getCity() %></h3>
		<h3><%= locationDTO.getStreet_address() %></h3>
		<h3><%= locationDTO.getPostal_code() %></h3>
		
		<a href="./update.do?location_id=<%= locationDTO.getLocation_id() %>">수정하기</a>
		<a href="./delete.do?location_id=<%= locationDTO.getLocation_id() %>">삭제</a>
	<%}else { %>
		<h3>없는 지역</h3>
	<%} %>
		</div>
	</section>

	<%@include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>