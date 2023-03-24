package ex10_Cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet1")
public class CookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1 = new Cookie("New-Jeans", "Hype-boy");
		Cookie cookie2 = new Cookie("address", URLEncoder.encode("서울시 금천구", "UTF-8")); // 유효하지 않은 문자(대표적으로 공백)은 UTF-8로 인코딩 해줘야
		Cookie cookie3 = new Cookie("job", URLEncoder.encode("스티븐 잡스", "UTF-8"));
		
		
		// 쿠키가 저장될 경로 설정하기
		cookie1.setPath("/01_Servlet"); // 컨텍스트 패스(/01_Servlet)
		cookie2.setPath("/01_Servlet/CookieServlet1"); // 전체 경로(서블릿 경로) (/01_Servlet/CookieServlet1)
		// 생략시 contextPath에 저장
		
		// 쿠키 유효시간 설정하기
		cookie1.setMaxAge(60*60*24*7); // 7일간 보관되는 쿠키 
		cookie2.setMaxAge(60 * 60); // 1시간 동안 보관되는 쿠키
		// 생략시 세션쿠키가 됨 : 브라우저를 닫을때까지 보관이 됨
		
		// 쿠키 저장하기
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	
		// CookieServlet2에다가 redirect
		response.sendRedirect("/01_Servlet/CookieServlet2");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
