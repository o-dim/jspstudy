package ex08_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AirKoreaApiServlet")
public class AirKoreaApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//요청 파라미터
		String sidoName = request.getParameter("sidoName");
		String returnType = request.getParameter("returnType");
		
		// 요청 주소와 서비스 키
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		String serviceKey = "87xlHrtNVNhlwTtrKjAjjsTFjnMTvNIa+UYcLlbJga5F0KOdN2/3lKtA3Je8te3lYZpearki0SbkbzT2P5ShTg==";
		
		// 요청 주소 만들기
		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
		apiURL += "&sidoName=" + URLEncoder.encode(sidoName, "UTF-8");
		apiURL += "&returnType=" + returnType;
		
		// URL
		URL url = new URL(apiURL);
		
		// httpurlconnection
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		// 요청 메소드
		con.setRequestMethod("GET");
		
		// returnType에 따른 Content-Type
		con.setRequestProperty("Content-Type", "application/" + returnType +"; charset=UTF-8");
		
		// 입력 스트림 생성
		BufferedReader reader = null;
		if(con.getResponseCode() == 200) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		// 입력 (API의 응답결과를 StringBuilder에 넣기)
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		
		// 입력 스트림, 접속 종료
		reader.close();
		con.disconnect();
		
		// API 결과를 ajax 응답 처리하기 
		response.setContentType("application/" + returnType + "; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
