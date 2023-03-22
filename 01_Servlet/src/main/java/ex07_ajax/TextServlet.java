package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TextServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 요청 인코딩 
			request.setCharacterEncoding("UTF-8");
			String model = request.getParameter("model");
			String strPrice = request.getParameter("price");
			
			int price = 0;
			if(strPrice != null && strPrice.isEmpty() == false) {
				price = Integer.parseInt(strPrice); // NumberFormatException 발생가능
			}
			// 마이너스 금액 예외 처리
			if(price < 0) {
				throw new RuntimeException(strPrice + "는 불가능한 숫자입니다");
			}
			// 응답 데이터 타입
			response.setContentType("text/plain;charset=UTF-8");
			
			//출력 스트림 생성
			PrintWriter out = response.getWriter();
			
			// 출력
			String resData = "모델은 " + model + " 가격은 " + price + "원입니다.";
			out.println(resData);
			out.flush();
			out.close();
			
		} catch (NumberFormatException e) {
			// ㅇㅖ외상황에 따른 응답 만들기
			// 응답 메세지 타입 
			response.setContentType("text/plain;charset=UTF-8");
			// 응답코드 : 600 (임의로 만든거임)
			response.setStatus(600);
			// 응답메세지 : 가격을 확인하세요
			PrintWriter out = response.getWriter();
			out.println("가격을 확인하시오");
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// ㅇㅖ외상	황에 따른 응답 만들기
			// 응답 메세지 타입 
			response.setContentType("text/plain;charset=UTF-8");
			// 응답코드 : 601 (임의로 만든거임)
			response.setStatus(601);
			// 응답메세지 : 위에 저장된 애로
			PrintWriter out = response.getWriter();
			out.println(e.getMessage());
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
