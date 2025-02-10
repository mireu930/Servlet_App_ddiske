<%@page import="com.root.app.locations.LocationDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.root.app.locations.LocationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<LocationDTO> ar = (List<LocationDTO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../template/common.jsp"%>
<link rel="stylesheet" href="/resources/css/list.css">
</head>
<body>
	<%@include file="/WEB-INF/views/template/header.jsp"%>

	<section class="contents wrap_left">
		<%@include file="/WEB-INF/views/template/nav.jsp"%>
		<div class="contents_right right">
			<!-- contents 내용 기술 -->
			<div class="contents_right_list">
				<table class="table_sprite">
					<thead>
						<tr>
							<th>지역번호</th>
							<th>도시명</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < ar.size(); i++) {
						%>
						<tr>
							<td><%=ar.get(i).getLocation_id()%></td>
							<td><a
								href="./detail.do?location_id=<%=ar.get(i).getLocation_id()%>">
									<%=ar.get(i).getCity()%></a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<a href="./add.do">추가</a>
		</div>
	</section>

	<%@include file="/WEB-INF/views/template/footer.jsp"%>
</body>
</html>