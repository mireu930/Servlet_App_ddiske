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
<link rel="stylesheet" href="../resources/css/reset.css">
</head>
<body>
  <c:import url="../frame/account/account_logo.jsp"></c:import>
  <div class="content">
  <table>
  	<thead>
  		<tr>
  			<th>계좌번호</th>
  			<th>상품번호</th>
  			<th>아이디</th>
  			<th>계좌잔액</th>
  			<th>가입날짜</th>
  		</tr>
  	</thead>
  	<tbody>
	<c:forEach items="${list}" var="ar">
  	<tr>
		<td><h3><a id="select" href = "./detail.do?accountNum=${ar.accountNum}">${ar.accountNum}</a></h3></td>
		<td><h3>${ar.productNum}</h3></td>
		<td><h3>${ar.user_name}</h3></td>
		<td><h3>${ar.accountsBalance}</h3></td>
		<td><h3>${ar.accountDate}</h3></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
  </div>
<c:import url="../frame/footer.jsp"></c:import>
</body>
</html>