<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl if</title>
</head>
<body>
	<c:set var="age" value="26" scope="page"></c:set>
	<c:if test="${age <= 100}">
		<h3>살아있구나.. 일하러 가자</h3>
	</c:if>
	<c:if test="${age > 100}">
		<h3>rip...ㅠ.ㅠ</h3>
	</c:if>
	
	<c:set var="score" value="79" scope="page"></c:set>
	<c:if test="${score >= 90 }">
		<div>A</div>
	</c:if>
	<c:if test="${score >= 80 and score < 90 }">
		<div>B</div>
	</c:if>
	<c:if test="${score >= 70 and score < 80 }">
		<div>C</div>
	</c:if>
	<c:if test="${score >= 60 and score < 70 }">
		<div>D</div>
	</c:if>
	<c:if test="${score < 60 }">
		<div>F</div>
	</c:if>
	
</body>
</html>