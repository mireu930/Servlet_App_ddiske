<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="./study_paramProcess.jsp" method="get">
		<div>
		<!--  readonly 읽기 전용이며 수정불가 파라미터로 사용가능 -->
		<!--  disabled 읽기 전용이며 수정불가 파라미터로 사용불가 -->
			<input type="text" name="p1" value="p1 data" readonly>
		</div>
		<div>
			<input type="hidden" value="hidden data" name="p2">
		</div>
		<div>
			남<input type="radio" value="male" name="p3">
			여<input type="radio" value="female" name="p3" checked>
		</div>
		<div>
			<select name="p4">
				<option value="KT">KT</option>
				<option value="SKT" selected>SKT</option>
				<option value="LG">LG</option>
			</select>
		</div>
		<div>
			야구<input type="checkbox" value="야구" name="p5">
			축구<input type="checkbox" value="축구" name="p5">
			농구<input type="checkbox" value="농구" name="p5">
			배구<input type="checkbox" value="배구" name="p5">
		</div>
		<button type="submit">SUBMIT</button>
	</form>
</body>
</html>