package ex11_upload_download;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업로드 경로
		String realPath = request.getServletContext().getRealPath("storage");
		File dir = new File(realPath);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		// 업로드 (HttpServletRequest request를 이용해서 MultipartRequest 객체를 생성하면 업로드가 곧바로 진행된다)
		MultipartRequest multipartRequest = new MultipartRequest(
				request, // HttpServeltRequest 전달
				realPath, // 업로드 경로
				1024 * 1024 * 10, // 최대 크기
				"UTF-8", // 인코딩
				new DefaultFileRenamePolicy() // 파일명 중복 처리 정책
				);
		
		// 요청 파라미터(MultipartRequest multipartRequest를 이용하여 파라미터를 가져와야한다)
		String uploader = multipartRequest.getParameter("uploader");
		String originName = multipartRequest.getOriginalFileName("filename"); // 원래이름
		String filesystemName = multipartRequest.getFilesystemName("filename"); // 저장된 첨부 파일명
		
		// 첨부파일 정보
		// 파일명, 경로, 최종수정일(yyyy-mm-dd), 파일크기(kb)
		File file = multipartRequest.getFile("filename");
		String name = file.getName();
		String parent = file.getParent();
		String lastModified = new SimpleDateFormat("yyyy-MM-dd").format(file.lastModified());
		String size = new DecimalFormat("#,##0").format(file.length() / 1024 + (file.length() % 1024 == 0? 0 : 1));
		
		// 응답 만들기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<ul style=\"list-style-type: circle; font-size : 24px;\">");
		out.println("<li>작성자 : " + uploader + "</li>");
		out.println("<li>원래 파일명 : " + originName + "</li>");
		out.println("<li>저장된 첨부 파일명 : " + filesystemName + "</li>");
		out.println("<li>파일명 : " + name + "</li>");
		out.println("<li>파일 경로 : " + parent + "</li>");
		out.println("<li>최종 수정일 : " + lastModified + "</li>");
		out.println("<li>파일 크기 : " + size + "</li>");
		out.println("<li><a href=\"/01_Servlet/FileListServlet?parent=" + URLEncoder.encode(parent, "UTF-8") + "\">첨부된 링크보기</a></li>");
		out.println("</ul>");
		out.flush();
		out.close();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
