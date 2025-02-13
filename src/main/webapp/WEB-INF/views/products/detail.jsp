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
 <%@ include file="../frame/product/product_detail_logo.jsp" %>
  <div class="content">
  <table>
		<c:if test="${not empty dto}">
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
	  		<tr>
				<td><h3>${dto.productNum}</h3></td>
				<td><h3>${dto.productName}</h3></td>
				<td><h3>${dto.productDetail}</h3></td>
				<td><h3>${dto.productRate}</h3></td>
				<td><h3>${dto.productDate}</h3></td>
			
			</tr>
		</tbody>
		</c:if>
	</table>
		<c:if test="${empty dto}">
			<td><h3>정보가 없습니다.</h3></td>
	</c:if>
  </div>
 <%@ include file="../frame/footer.jsp" %>
</body>
</html>