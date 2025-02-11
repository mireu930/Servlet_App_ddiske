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
					<h1>로그인</h1>
					<form action="./login.do" method="post">
						<fieldset>
							<h5>
								사원번호 : <input type="text" name="employee_id">
							</h5>
						</fieldset>
						<fieldset>
							Password : <input type="password" name="password">
						</fieldset>
						<fieldset>
							<div class="button_container">
								<button class="btn">
									<span>로그인</span>
								</button>
							</div>
						</fieldset>
					</form>
				</div>
			</section>

			<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>