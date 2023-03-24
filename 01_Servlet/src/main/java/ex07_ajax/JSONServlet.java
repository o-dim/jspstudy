package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/JSONServlet")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String strAge = request.getParameter("age");
			
			int age = 0;
			
			if(strAge != null && strAge.isEmpty() == false) {
				age = Integer.parseInt(strAge);
			}
			
			// 나이 예외 처리
			if(age > 100 || age < 0) {
				throw new MyHandleException(age + "살은 잘못된 나이입니다.", 600);
			}
			if(name.length() < 2 || name.length() > 6 ) {
				throw new MyHandleException(name + "은 잘못된 이름입니다.", 601);
			}
			
			// 응답할 JSON 데이터
			JSONObject obj = new JSONObject();
			obj.put("name", name);
			obj.put("age", age);
			// System.out.println(obj.toString());
			
			// 응답 데이터 타입
			response.setContentType("application/json;charset=UTF-8");
			
			// 출력 스트림 생성
			PrintWriter out = response.getWriter();
			
			// 출력
			String resData = obj.toString();
			out.println(resData); // 텍스트 형식으로 된 JSON 데이터 반환하기
			out.flush();
			out.close();
		} catch (MyHandleException e) {
			response.setContentType("text/plain;charset=UTF-8");
			response.setStatus(e.getErrorCode());
			response.getWriter().println(e.getMessage());
		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
