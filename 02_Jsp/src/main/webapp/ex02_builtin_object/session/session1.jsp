<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- sessionID는 유효아이디이자 쿠키 이름과 같거든.. 그래서 나중에 쿠키로 이용할 수 있어 --%>
	<%
		String sessionId = session.getId();
		
	%>
	<h1><%=sessionId%></h1>
</body>
</html>