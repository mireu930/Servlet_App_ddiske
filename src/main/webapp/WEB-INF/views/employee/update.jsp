<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "update.do" method = "post">
		<input type ="text" name = "employee_id" value ="${sessionScope.user.employee_id}" readonly>
		<input type = "text" name = "first_name" value = "${sessionScope.user.first_name }">
		<input type = "text" name = "last_name" value = "${requestScope.user.last_name }">
		<input type="submit" value ="수정">
	</form>

</body>
</html>