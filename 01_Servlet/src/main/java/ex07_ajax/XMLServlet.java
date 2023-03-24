package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

@WebServlet("/XMLServlet")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title"); 
		String author = request.getParameter("author"); 
		String strPrice = request.getParameter("price"); 
		
		int price = 0;
		if(strPrice != null && strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		
		//응답할 xmL 만들기 (JSONObject 만든 다음에 XML로 변환)
		/*
		 * <book>
		 * 		<title></title>
		 * 		<author></author>
		 * 		<price></price>
		 * </book>
		 * 
		 * */
		JSONObject obj = new JSONObject();
		obj.put("title", title);
		obj.put("author", author);
		obj.put("price", price);
		JSONObject obj2 = new JSONObject();
		obj2.put("book", obj);
		
		String resData = XML.toString(obj2);
		
		// 응답 데이터 타입 
		response.setContentType("application/xml;charset=UTF-8");
		
		response.getWriter().println(resData);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
