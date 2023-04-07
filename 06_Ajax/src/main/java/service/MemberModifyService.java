package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberModifyService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터를 이용해서 Member member 객체 만들기
		// 아이디는 변하지 않으니 아이디 제외
		Member member = new Member();
		member.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setAddress(request.getParameter("address"));
		
		try {
			// Member member 객체 정보를 이용해 db의 내용을 수정
			int updateResult = MemberDAO.getInstance().updateMember(member);
			
			// 응답 데이터 형식
			response.setContentType("application/json; charset=UTF-8");
			
			// 응답 데이터 만들기
			JSONObject obj = new JSONObject();
			obj.put("updateResult", updateResult);
			
			// 응답
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			response.setContentType("text/plain; charset=UTF-8");
			response.setStatus(777);
			
			String msg = "변경사항이 저장되지 않았습니다.";
			
			PrintWriter out = response.getWriter();
			out.println(msg);
			out.flush();
			out.close();
		}
		
	}

}
