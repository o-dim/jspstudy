<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		pageContext.setAttribute("a", 1);
		request.setAttribute("a", 10);
		session.setAttribute("a", 100);
		application.setAttribute("a", 1000);
	%>
	<h1><%=pageContext.getAttribute("a") %></h1>
	<h1><%=request.getAttribute("a") %></h1>
	<h1><%=session.getAttribute("a") %></h1>
	<h1><%=application.getAttribute("a") %></h1>
</body>
</html>