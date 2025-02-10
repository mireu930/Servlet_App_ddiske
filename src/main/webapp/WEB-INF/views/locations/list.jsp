<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	LocationDAO locationDAO = new LocationDAO();
	List<LocationDTO> ar = locationDAO.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
	border: 1px solid black;
	margin: 0 auto;
	width: 50%;
	}
	table tr, td, th {
	border: 1px solid black;
	}
</style>
</head>
<body>
	<h1>Location list</h1>
	<table>
		<thead>
			<tr>
				<th>지역번호</th><th>도시명</th>
			</tr>
		</thead>
		<tbody>
			<% for(int i = 0; i < ar.size(); i++) { %>
				<tr>
					<td><%= ar.get(i).getLocation_id() %></td>
					<td>
						<a href="./detail.jsp?location_id=<%=ar.get(i).getLocation_id()%>">
						<%= ar.get(i).getCity() %></a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	<a href="./add.jsp">추가</a>
</body>
</html>