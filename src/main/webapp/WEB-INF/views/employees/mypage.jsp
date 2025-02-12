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
			<div>
				<h3>ID : ${sessionScope.user.employee_id }</h3>
				<h3>First Name : ${requestScope.user.first_name }</h3>
				<h3>Last Name : ${requestScope.user.last_name }</h3>
				<h3>Email : ${requestScope.user.email }</h3>
				<h3>Phone Number : ${requestScope.user.phone_number }</h3>
				<h3>Salary : ${requestScope.user.salary }</h3>
				<h3>Commission : ${requestScope.user.commission_pct }</h3>
				<h3>Department ID : ${requestScope.user.department_id }</h3>
				<h3>Manager ID : ${requestScope.user.manager_id }</h3>
				<h3>Job ID : ${requestScope.user.job_id }</h3>
				<h3>Hire Date : ${requestScope.user.hire_date }</h3>
			</div>
			
			<div>
				<a href="./update.do">정보 수정</a>
			</div>
			
		</div>
	</section>

	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>