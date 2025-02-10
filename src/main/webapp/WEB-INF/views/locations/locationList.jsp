<%@page import="java.util.ArrayList"%>
<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
LocationDAO dao = new LocationDAO();
List<LocationDTO> list = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/style.css">
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
	<%@ include file="../template/header.jsp" %>
  <section class = "wrap_left content">
    <%@ include file = "../template/nav.jsp" %>
    <nav class = " right content_right">
		<table>
		<thead>
			<tr>
				<th>지역아이디</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i=0;i<list.size();i++){%>
			<tr>
				<td><a
					href="locationDetail.jsp?location_id=<%= list.get(i).getLocation_id()%>">
						<%= list.get(i).getLocation_id()%></a></td>
						<td>
							<%= list.get(i).getStreet_address()%></td>
			</tr>
			<%}%>
		</tbody>
		<tfoot>
			<tr>
				<td><a href="./locationAdd.jsp">지역등록</a></td>
			</tr>
		</tfoot>
	</table>
	 </nav>
  </section>
	 <%@ include file = "../template/footer.jsp" %>
</body>
</html>