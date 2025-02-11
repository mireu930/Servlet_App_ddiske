<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/resources/css/add.css">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "login.do" method = "post">
		<fieldset>
      <legend>아이디</legend>
        <input type = "text" name = "employee_id">
    </fieldset>
    <fieldset>
      <legend>비밀번호</legend>
      <input type = "password" name = "password">
    </fieldset>
      <fieldset>
        <input type = "submit" value ="로그인">
      </fieldset>
	</form>
</body>
</html>