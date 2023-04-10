<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>	
	<form method="post" action="" id="addS">
		<div>
			<h1>신규학생등록</h1>
		</div>
		<div>
			<input type="text" id="name">이름
			<input type="number" id="kor">국어
			<input type="number" id="eng">영어
			<input type="number" id="math">수학
		</div>
		<hr>
		<button>작성완료</button>
	</form>
		<input type="reset">다시 작성
		<button onclick="/list.do">목록으로</button>
</body>
</html>