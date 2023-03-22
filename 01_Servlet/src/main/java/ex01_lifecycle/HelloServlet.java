package ex01_lifecycle;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HelloServlet() {
        super();
        System.out.println("생성자 호출");

    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
	}
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출");
	
		switch(request.getMethod()) {
		case "GET" :
			doGet(request, response);
			break;
		case "POST" :
			doPost(request, response);
		}
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답정보를 가진 객체 : response
		
		// 클라이언트로 정보(텍스트)를 보내기 위한 출력 스트림 : response.getWriter() - printeWriter
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
