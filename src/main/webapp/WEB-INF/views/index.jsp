<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<c:import url="/WEB-INF/views/template/common.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
  <section class = "wrap_left content">
  <c:import url="/WEB-INF/views/template/nav.jsp"></c:import>
    <nav class = " right content_right">
		<h4>foreach</h4>
		<c:forEach begin="1" end="10" var="i">
			<h4>${ i }</h4>
		</c:forEach>
		<br>
		<c:forEach begin="1" end="10" step = "2" var="i">
			<h4>${ i }</h4>
		</c:forEach>
		<hr>
		<c:forEach begin="1" end="10" var="i" step = "1" varStatus="st">
			<h4>${ i }</h4>
			<h4>시작값: ${st.begin }</h4>
			<h4>시작값: ${st.end }</h4>
			<h4>시작값: ${st.step }</h4>
			<hr>
		</c:forEach>
		
		<d:formatDate value="${now}" var = "year" pattern="yyyy"/>
		<h4>${year}</h4>
		<h4>${year-1}</h4>
    </nav>
  </section>
<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
</body>
</html>