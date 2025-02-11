<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
<link rel="/resources/css/button.css"> 
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>

	<section class="contents wrap_left">
		<c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
		<div class="contents_right right">
			<!-- contents 내용 기술 -->
			<h1>사원 등록</h1>
			<form action="./join.do" method="post">
				<fieldset>
					<h5>
						이름 : <input type="text" name="first_name">
					</h5>
					<h5>
						성 : <input type="text" name="last_name">
					</h5>
				</fieldset>
				<fieldset>
					<h5>
						E-mail : <input type="text" name="email">
					</h5>
					<h5>
						Phone_number : <input type="text" name="phone_number">
					</h5>
				</fieldset>
				<fieldset>
					Job_ID : <!-- <input type="text" value="SA_REP" name="job_id"> --> <select name="job_id">
						<option>SA_REP</option>
					</select> Salary : <input type="text" name="salary">
					Commission_pct : <input type="text" name="commission_pct"><br>
					Manager_ID : <!-- <input type="text" value="145" name="manager_id"> --> <select name="manager_id">
						<option>145</option>
					</select> Department_ID : <!-- <input type="text" value="80" name="department_id"> --> <select name="department_id">
						<option>80</option>
					</select>
				</fieldset>
				<fieldset>
					Password : <input type="password" name="password">
				</fieldset>
				<fieldset>
					<div class="button_container">
						<button class="btn">
							<span>등록</span>
						</button>
					</div>
				</fieldset>
			</form>
		</div>
	</section>

	<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>