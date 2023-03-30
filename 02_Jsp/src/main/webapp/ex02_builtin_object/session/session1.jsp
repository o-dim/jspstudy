<%@page import="java.text.SimpleDateFormat"%>
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
		long creationTime = session.getCreationTime();
		String strCreationTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(creationTime);
		long lastAccessedTime = session.getLastAccessedTime();
		String strLastAccessedTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lastAccessedTime);
		int maxInactiveInterval = session.getMaxInactiveInterval();
				
	%>
	<h1>세션 아이디 : <%=sessionId%></h1>
	<h1>세션 생성시간 : <%=creationTime%></h1>
	<h1>세션 생성시간 : <%=strCreationTime %></h1>
	<h1>세션 최종접속시간 : <%=lastAccessedTime%></h1>
	<h1>세션 최종접속시간 : <%=strLastAccessedTime%></h1>
	<h1>세션 유지시간 : <%=maxInactiveInterval%></h1>
</body>
</html>