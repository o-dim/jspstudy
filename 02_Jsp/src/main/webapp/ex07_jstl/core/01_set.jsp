<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="age" value="26" scope="page"></c:set>
	<c:set var="isAdult" value="${age >= 20}" scope="page"></c:set>
	<c:set var="height" value="174" scope="page"></c:set>
	<c:set var="weight" value="62" scope="page"></c:set>
	<c:set var="bmiTest" value="${(weight div ((height div 100) * (height div 100)))}"></c:set>
	<c:set var="health" value="${bmiTest >= 25 ? '비만' : bmiTest >= 20 ? '정상' : '저체중'}" scope="page"></c:set>
	<ul>
		<li>나이 : ${age}살</li>
		<li>성인여부 : ${isAdult? '맞다' : '아니다'}</li>
		<li>bmi지수 : ${bmiTest}</li>
		<li>건강상태 : ${health}</li>
	</ul>
</body>
</html>