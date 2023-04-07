package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberAddService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 요청 파라미터를 db로 보낼 number 객체로 만들기
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setAddress(request.getParameter("address"));
		
		// execute() 메소드에 throws Exception 처리가 되어 있어 try catch 할 필요가 없으나 
		// 회원 추가를 실패할 경우 ajax() 메소드로 실패 메세지를 전달하기 위해서 try catch를 사용한다		
		try {
			// Member member  객체 db에 저장
			int insertResult = MemberDAO.getInstance().insertMember(member);
			// 응답데이터 형식
			response.setContentType("application/json; charset = UTF-8");
			JSONObject obj = new JSONObject();
			obj.put("insertResult", insertResult);
			// 응답 데이터
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// 응답 데이터 형식 (일반 텍스트) -> 예외사유를 텍스트로 전달하기 위해서
			response.setContentType("text/plain; charset=UTF-8");
			// 응답 코드 만들기
			response.setStatus(500);
			// 응답 데이터 만들기 
			String msg = "신규 등록이 실패했습니다.\n입력 데이터를 확인하세요.";
			// 응답 (catch문의 응답이므로 ajax의 error로 전달됨)
			PrintWriter out = response.getWriter();
			out.println(msg);
			out.flush();
			out.close();
			
		}
	} 

}
