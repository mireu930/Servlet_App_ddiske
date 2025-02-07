<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.add_input {
        width: fit-content;
        display: flex;
    }
</style>
</head>
<body>
	<h1>부서 추가 페이지</h1>
	
	<form action="./addProcess.jsp" method="post">
        <fieldset>
            <legend>부서명</legend>
            <input type="text" name="department_name">
        </fieldset>
        <fieldset>
            <legend>매니저ID</legend>
            <input type="text" name="manager_id">
        </fieldset>
        <fieldset>
            <legend>지역코드</legend>
            <input type="text" name="location_id">
        </fieldset>
		<div class="button_container">
            <button class="btn">
                <span>등록</span>
            </button>
        </div>
    </form>
	
</body>
</html>