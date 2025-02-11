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
	<form action= "./join.do" method = "post">
		<fieldset>
      	<legend>성</legend>
        <input type = "text" name = "first_name">
    </fieldset>
    <fieldset>
      <legend>이름</legend>
      <input type = "text" name = "last_name">
    </fieldset>
    <fieldset>
      <legend>이메일</legend>
      <input type = "text" name = "email">
    </fieldset>
    <fieldset>
      <legend>폰번호</legend>
      <input type = "text" name = "phone_number">
    </fieldset>
    <fieldset>
      <legend>id</legend>
      <input type = "text" name = "job_id">
    </fieldset>
    <fieldset>
      <legend>연봉</legend>
      <input type = "text" name = "salary">
    </fieldset>
    <fieldset>
      <legend>상여금</legend>
      <input type = "text" name = "commision_pct">
    </fieldset>
    <fieldset>
      <legend>매니저id</legend>
      <input type = "text" name = "manager_id">
    </fieldset>
    <fieldset>
      <legend>부서id</legend>
      <input type = "text" name = "department_id">
    </fieldset>
    <fieldset>
      <legend>비밀번호</legend>
      <input type = "password" name = "password">
    </fieldset>
      <fieldset>
        <input type = "submit" value ="등록">
      </fieldset>
	</form>
</body>
</html>