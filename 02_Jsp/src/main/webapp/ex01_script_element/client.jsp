<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 주석 --%>
	<%
		int a = 1;
		
	%>
	<h1>a = <%=a%></h1>
	<%!
		public int getNumber(){
			return (int)(Math.random() * 10); // 0~9 중 하
		}
	%>
	<h1>발생한 난수 : <%=getNumber()%></h1>
	
	<%
		LocalDate today = LocalDate.now();
	%>
	<h1>현재 날짜 : <%=today%></h1>
	
	<%-- 자바 변수를 자스에서 사용해보기  --%>
	<% String str = "Hello World"; %>
	<script>
		alert('<%=str%>');
	</script>
	
	<%-- 연습1. getNumber() 메소드의 반환결과가 5이상이면 "큰 수", 아니면 "작은 수" 출력하기 --%>
	<%
		if(getNumber() >= 5){
	%>
		<h1>큰 수</h1>
	<% } else { %>
		<h1>작은 수</h1>
	<% } %>
	
	<%-- 연습2. 1월~12월로 표시되는 select 태그를 작성하시오 --%>
	<select name = "month">
		<% for(int m = 1; m < 13; m ++) { %>
		<option value ="<%=m%>"><%=m%>월</option>
		<% } %>
	</select>
</body>
</html>