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
  <%@ include file="../frame/product/product_logo.jsp" %>
  <div class="content">
  <table>
  <thead>
  	<tr>
  		<th>상품번호</th>
  		<th>상품이름</th>
  		<th>상품상세설명</th>
  		<th>이자율</th>
  		<th>상품기간</th>
  	</tr>
  </thead>
  <tbody>
	<c:forEach items="${list}" var="ar">
		<tr>
		<td><h3><a id="select" href = "./detail.do?productNum=${ar.productNum}">${ar.productNum}</a></h3></td>
		<td><h3>${ar.productName}</h3></td>
		<td><h3>${ar.productDetail}</h3></td>
		<td><h3>${ar.productRate}</h3></td>
		<td><h3>${ar.productDate}</h3></td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
  </div>
  <%@ include file="../frame/footer.jsp" %>
</body>
</html>