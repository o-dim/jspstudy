<%@page import="java.time.LocalDate"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ex06_el.Webtoon"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>for문보여준다</title>
</head>
<body>
	<%--c:forEach --%>
	<c:forEach var="n" begin="1" end="5" step="1">
		<p>${n}</p>
	</c:forEach>
	
	
	<c:forEach var="m" begin="1" end="5" step="1">
		<p>${6-m}</p>
	</c:forEach>
	<hr>
	<%
		String[] seasons = {"봄","여름","가을","겨울"};
		pageContext.setAttribute("seasons", seasons);	 // EL 사용을 위해 pageContext에 저장한다 
	%>
	<c:forEach var="season" items="${seasons}" varStatus="vs">
		<div>인덱스 : ${vs.index},  순번 : ${vs.count}, 요소 : ${season}</div>
	</c:forEach>
	
	<!-- 리스트 -->
	<%
		List<String> jobs = Arrays.asList("개발자", "기획자", "PM", "퍼블리셔");
		pageContext.setAttribute("jobs", jobs);
	%>
	<c:forEach var="job" items="${jobs}" varStatus="k">
		<div>인덱스 : ${k.index}, 순번 : ${k.count}, 요소 : ${job} </div>
	</c:forEach>
	
	
	
	<!--  객체 + 리스트  -->
	<%
		List<Webtoon> webtList = new ArrayList<>();
		webtList.add(new Webtoon(415, "트와일라잇", 9.95, LocalDate.of(2022, 11, 16)));
		webtList.add(new Webtoon(416, "내시반청", 9.95, LocalDate.of(2022, 11, 23)));
		webtList.add(new Webtoon(417, "보통의 시선", 9.95, LocalDate.of(2022, 11, 30)));
		webtList.add(new Webtoon(418, "텐션", 9.95, LocalDate.of(2022, 12, 7)));
		webtList.add(new Webtoon(419, "HBLJ", 9.95, LocalDate.of(2022, 12, 14)));
		pageContext.setAttribute("webtList", webtList);
	%>
	<table border="1">
		<tbody>
			<c:forEach var="webtoon" items="${webtList}">
			<tr>
				<td>${webtoon.webtoonNo}</td>
				<td>${webtoon.title}</td>
				<td>${webtoon.star}</td>
				<td>${webtoon.uploadDate}</td>
			</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>