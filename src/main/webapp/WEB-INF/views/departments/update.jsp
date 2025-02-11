<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>

	<section class="contents wrap_left">
		<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
		<div class="contents_right right">
			<!-- contents 내용 기술 -->
			<h1>Update Form</h1>
	<form action="./update.do" method = "post">
		<input type="hidden" name="department_id" value="${requestScope.dto.department_id }">
		부서명 : <input type="text" name="department_name" value="${requestScope.dto.department_name }"><br>
		매니저ID : <input type="text" name="manager_id" value="${dto.manager_id }"><br>
		지역번호 : <input type="text" name="location_id" value="${dto.location_id }"><br>
		<button type="submit">수정하기</button>
	</form>
		</div>
	</section>

	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>