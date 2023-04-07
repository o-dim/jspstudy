<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
<script>
	
	function goEdit() {
		location.href = "${contextPath}/edit.do?bbsNo=${bbs.bbsNo}";
	}
	function goRemove(){
		if(confirm('삭제하시겠습니까?')){
			$('#frm_remove').submit();
		}
	}
	function goList(){
		location.href = "${contextPath}/list.do";
	}
	
</script>
</head>
<body>
	<div><h1>상세보기</h1></div>
	<div>
		<div>BBS_No : ${bbs.bbsNo}</div>
		<div>title : ${bbs.title}</div>
		<div>date : ${bbs.createdDate}</div>
		<div>modified date : ${bbs.modifiedDate == null? '없음' : bbs.modifiedDate}</div>
		<div>content : ${bbs.content}</div>
	</div>
	<div>
		<input type="button" value="edit" onclick="goEdit()">
		<input type="button" value="delete" onclick="goRemove()">
		<input type="button" value="back to List" onclick="goList()">
		<form id="frm_remove" method="post" action="${contextPath}/remove.do">
			<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
		</form>
	</div>
	
</body>
</html>