package practice06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateFileServlet")
public class CreateFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 파일명 : yyyy-mm-dd-작성자-제목.txt
		 파일경로 : Realpath에 stroage 디렉터리를 만들어서 저장
		 파일 내용 : 내용 그대로 추가
		 */;
		response.setCharacterEncoding("UTF-8");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String filename = LocalDate.now().toString() + "-" + writer + "-" + title + ".txt";
		File dir = new File(request.getServletContext().getRealPath("stroage"));
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(content);
		bw.flush();
		bw.close();
		
		
		/*
		 FileResponseServlet으로 리다이렉트
		 파일명 전
		 */
		response.sendRedirect("/01_Servlet/FileResponseServlet?filename=" + URLEncoder.encode(filename, "UTF-8"));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
