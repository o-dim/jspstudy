<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	<c:redirect url="/ex07_jstl/core/05_redirect2.jsp" context="${contextPath}">
		<c:param name="age" value="26"></c:param>
	</c:redirect>
</body>
</html>