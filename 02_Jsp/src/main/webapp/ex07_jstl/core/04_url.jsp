<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>›
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<c:url value='/resources/js/lib/jquery-3.6.4.min.js'/>"></script>
<% pageContext.setAttribute("now", System.currentTimeMillis());  %>
<%-- 파라미터 dt를 현재 시간으로 전달하면 실행할때마다 경로가 변하기 때문에 매번 Js 파일을 읽는다 --%>
<script src=
	"<c:url value="04_url.js">
		<c:param name="dt" value="${now}"/>
	</c:url>">
</script>
<script>
	if(confirm('이동할까요?')){
		location.href='<c:url value="/ex07_jstl/core/01_set"/>';
	}
</script>
</head>
<body>


</body>
</html>