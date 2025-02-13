<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/style.css">
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
<%@ include file="../frame/account/account_detail_logo.jsp" %>
  
  <div class="content">
  <table>
  	<c:if test="${not empty dto}">
  <thead>
  		<tr>
	  		<th>게좌번호</th>
	  		<th>상풉번호</th>
	  		<th>이름</th>
	  		<th>계좌잔액</th>
	  		<th>가입날짜</th>
  		</tr>
  	</thead>
  	<tbody>
		<tr>
			<td><h3>${dto.accountNum}</h3></td>
			<td><h3>${dto.productNum}</h3></td>
			<td><h3>${dto.user_name}</h3></td>
			<td><h3>${dto.accountsBalance}</h3></td>
			<td><h3>${dto.accountDate}</h3></td>
		</tr>
	</tbody>
	</c:if>
	</table>
	
	<c:if test="${empty dto}">
		<h3>정보가 없습니다.</h3>
	</c:if>
  </div>
<%@ include file="../frame/footer.jsp" %>
</body>
</html>