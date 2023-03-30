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

	<h1>${a}</h1>
	
	<%-- 모든 영역 속성 a 확인  --%>
	<h3>${pageScope.a}</h3>
	<h3>${requestScope.a}</h3>
	<h3>${sessionScope.a}</h3>
	<h3>${applicationScope.a}</h3>
	
	<%
		pageContext.setAttribute("x", 5);
		pageContext.setAttribute("y", 2);
	%>
	<ul>
		<li>${x + y}</li>
		<li>${x - y}</li>
		<li>${x * y}</li>
		<li>${x div y}</li>
		<li>${x mod y}</li>
	</ul>
		
	<ul>
		<li>${x lt y}</li>
		<li>${x le y}</li>
		<li>${x gt y}</li>
		<li>${x ge y}</li>
		<li>${x eq y}</li>
		<li>${x ne y}</li>  
	</ul>
	
	<ul>
		<li>${x eq 5 and y eq 2 }</li>
		<li>${x eq 6 and y eq 2 }</li>
		<li>${not (x eq 5)}</li>
	</ul>
	
	<%-- 객체 사용하기 --%>
	<%
		Book book2 = new Book();
		book2.setAuthor("황순원");
		book2.setTitle("소나기");
		book2.setPrice(10000);
		pageContext.setAttribute("book2", book2);
	%>
	<ul>
		<li>저자 : ${book2.author}</li>
		<li>제목 : ${book2.title}</li>
		<li>가격 : ${book2.price}</li>
	</ul>
</body>
</html>