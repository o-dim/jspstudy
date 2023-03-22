package ex04_response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResponseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파라미터 처리하기
		request.setCharacterEncoding("UTF-8");
		
		String model = request.getParameter("model");
		String strPrice = request.getParameter("price");
		
		int price = 0;
		if(strPrice != null && strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		
		// 응답 만들기
		// 1. 응답한 데이터의 MIME 타입과 UTF-8 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 응답 스트림 생성 (IOException 처리가 필요함 -> 이미 처리되어있다)
		PrintWriter out = response.getWriter(); // PrintWriter의 응답 메소드 : append(), writer(), print(), println() 등
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>나의 첫 응답</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>모델명 : " + model + "</h1>");
		out.println("<h1>가격 : " + price + "원</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush(); // 출력 스트림에 남아있는 데이터를 모두 내보내기 
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
