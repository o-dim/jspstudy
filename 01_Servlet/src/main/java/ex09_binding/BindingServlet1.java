package ex09_binding;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BindingServlet1")
public class BindingServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// HttpServletRequest에 저장하기
		request.setAttribute("a", 100);
		
		// HttpSession에 저장하기
		HttpSession session = request.getSession();
		session.setAttribute("a", 200);
		
		// ServletContext에 저장하기
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("a", 300);
		
		// 페이지이동하기
		// 1. HttpServletRequest의 전달이 없는 이동
		// response.sendRedirect("/01_Servlet/BindingServlet2");
		
		// 2. HttpServletRequest의 전달이 있는 이동 : forward
		request.getRequestDispatcher("/BindingServlet2").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
