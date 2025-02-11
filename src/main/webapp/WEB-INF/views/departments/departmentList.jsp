<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
				<th>부서번호</th>
				<th>부서명</th>
			</tr>
		</thead>
		<tbody>
					<c:forEach items="${list}" var="list" varStatus="st">
						<tr>
							<%-- <td>
							<h4>현재아이템:${st.current}</h4>
							<h4>현재아이템:${st.index}</h4>
							<h4>현재아이템:${st.count}</h4>
							<h4>현재아이템:${st.first}</h4>
							<h4>현재아이템:${st.last}</h4>
							
							</td> --%>
							<td>${pageScope.list.department_id}</td>
							<td><a
								href="departmentDetail.do?department_id=${pageScope.list.department_id}">
									${list.department_name}</a></td>
						</tr>
					</c:forEach>

				</tbody>
		<tfoot>
			<tr>
				<td><a href="departmentAdd.do">부서등록</a></td>
			</tr>
		</tfoot>
	</table>
	
    </nav>
  </section>
  <%@ include file = "../template/footer.jsp" %>

	

</body>
</html>