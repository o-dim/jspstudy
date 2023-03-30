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
	<c:choose/>
		<c:when test="${age <= 7}"/>
			<c:set var="result" value="미취학아동" scope="page"/>
		<c:when test="${age <=13}"/>
			<c:set var="result" value="초등학생" scope="page"/>
		<c:when test="${age <=16 }"/>
			<c:set var="result" value="중학생" scope="page"/>		
		<c:when test="${age <=19 }"/>
			<c:set var="result" value="고등학생" scope="page"/>		
		<c:otherwise/>
			<c:set var="result" value="얼은." scope="page"/>				
	
	<h1>${age}살은 ${result}입니다.</h1>
</body>
</html>