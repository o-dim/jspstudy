<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

<%
	// 자동 로그인 확인
	// 쿠키에 session_id login_id가 있으면 자동 로그인을 해야한다
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		outer:
		for(int i = 0; i < cookies.length; i++){
			if(cookies[i].getName().equals("session_id")){
				for(int j = 0; j < cookies.length; j++){
					if(cookies[j].getName().equals("login_id")){
						session.setAttribute("loginId", cookies[j].getValue());
						break outer;
					}
				}
			}
		}
	}
%>

	<%if(session.getAttribute("loginId") == null) { %>
	<div>
		<form method="post" action="02_login.jsp">
			<div><input type="text" name="id" id="id" placeholder="id"></div>
			<div><input type="password" name="pw" placeholder="pw"></div>
			<div>
				<input type="checkbox" name="chk_auto_login" id="chk_auto_login">
				<label for="chk_auto_login">자동로그인</label>
			</div>
			<div><button>login</button></div>	
		</form>
	</div>

	<% } else { %>
	<div>
		Hello, <%=session.getAttribute("loginId") %>
		<input type="button" value="logout" onclick="fnLogout()">
	</div>
	<% } %>
	<script>
		function fnLogout() {
			location.href="03_logout.jsp";
		}
	</script>
</body>
</html>