<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>remember me</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");

		// 체크박스를 해제한 상태로 submit 할 시에는 null 처리를 하시오 
		String chkRememberId = request.getParameter("chk_remember_id");
	
		// 아이디 기억하기를 체크했다면 chkRememberId가 null이 아니다
		if(chkRememberId != null){
			Cookie cookie = new Cookie("remember_id", id);
			cookie.setMaxAge(60*60*24*30);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember_id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// 다시 로그인 창으로 돌아가기
		response.sendRedirect("01_form.jsp");
	
	%>
</body>
</html>