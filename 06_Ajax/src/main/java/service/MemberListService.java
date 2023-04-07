package service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberListService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 하나의 서비스는 여러 개 DAO 메소드를 호출할 수 있다
		MemberDAO dao = MemberDAO.getInstance();
		List<Member> memberList = dao.selectAllMembers();
		int memberCount = dao.getMemberCount();
		
		// 응답할 JSON 데이터 만들기
		JSONObject obj = new JSONObject();
		obj.put("memberCount", memberCount);
		obj.put("memberList", memberList); // JSON 라이브러리가 ArrayList를 배열로 ㅁ바꾸고, Java의 Member 객체를 JavaScript의 객체로 바꾼다
		
		// 응답하기 (요청한 곳으로 그대로 응답된다. 즉 ajax() 메소드로 응답처리 되는 것)
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(obj.toString()); // JSON데이터를 텍스트 형식으로 변경해서 반환하기
		out.flush();
		out.close();
	}

}
