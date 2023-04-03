<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str" value="Hel:o WOrLd" scope="page"/>
	
	<h3>${fn:length(str)}</h3>
	<h3>${fn:substring(str, 1, 5)}</h3>
	<h3>${fn:substringBefore(str, 'W')}</h3>
	<h3>${fn:substringAfter(str, 'W')}</h3>
	<h3>${fn:indexOf(str, 'l')}</h3>
	<h3>${fn:replace(str, 'l', 'mimi')}</h3>
	
	<c:set var="str2" value="<script>location.href='/';</script>"/>
	<h3>${fn:escapeXml(str2)}</h3>
	
	<c:if test="${fn:startsWith(str, 'Hel:o')}">
		<h3>hello로 시작한다</h3>
	</c:if>
	<c:if test="${fn:endsWith(str, 'Ld')}">
		<h3>Ld로 끝난다</h3>
	</c:if>
	<c:if test="${fn:contains(str, 'orr')}">
		<h3>얘가나오면 안돼~</h3>
	</c:if>
	<c:if test="${fn:containsIgnoreCase(str, 'h')}">
		<h3>H, h가 포함됨</h3>
	</c:if>
	
	<c:set var="str3" value="1, 2, 3, 4, 5, 6, 7, 8, 9, 0"/>
	<c:set var="items" value="${fn:split(str3, ',')}" />
	<c:forEach var="item" items="${items}" varStatus="vs">
		<div>
			${vs.index} - ${item}
		</div>
	</c:forEach>
	
	<%-- 원상복구 시키기 --%>
	<c:set var="str4" value="${fn:join(items, ',')}" scope="page"/>
	
</body>
</html>