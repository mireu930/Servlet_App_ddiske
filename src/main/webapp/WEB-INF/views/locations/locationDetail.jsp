<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	LocationDTO dto = (LocationDTO)request.getAttribute("dto");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, table th, table td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>
	<table>
	<%if (dto != null) {%>
		<thead>
			<tr>
				<th>디테일</th>
				<th>디테일2</th>
				<th>디테일3</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=dto.getLocation_id()%></td>
				<td><%=dto.getStreet_address()%></td>
				<td><a href = "./locationDeleteProcess.do?location_id=<%=dto.getLocation_id()%>">삭제</a></td>
				<td><a href ="./locationUpdate.do?location_id=<%=dto.getLocation_id()%>">수정</a></td>
				<%} else {%>
				<h3>없는 아이디입니다.</h3>
				<%}%>
			</tr>
		</tbody>
	</table>
</body>
</html>