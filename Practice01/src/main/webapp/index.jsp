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
</head>
<body>
	<div>
		<h1>학생관리</h1>
	</div>
	<div>
		<button>신규학생등록</button>
	</div>
	<hr>
	<form>
		평균 <span><input type="text" placeholder="begin"></span>~<span><input type="text" placeholder="end"></span>
		<span><button>조회</button></span><span><button id="top3" onclick="fnTop3()">전체조회</button></span>
	</form>
	<hr>
	<table>
		
		<thead>
			<p> 전체학생 <p> <span></span>명
		</thead>
		<tbody>
				
		</tbody>
	</table>
	<script>
		function fnTop3() {
			$('#top3')
		}
	</script>
</body>
</html>