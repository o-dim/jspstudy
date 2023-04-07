package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberDetailService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 요청 파라미터
		String strMemberNo = request.getParameter("memberNo");
		int memberNo = Integer.parseInt(strMemberNo);
		
		// db에서 memberNo 값을 가진 ㅁ회원 정보 받아오기
		Member member =	MemberDAO.getInstance().selectMemberbyNo(memberNo);
		//응답 데이터 형식 (JSON)
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 만들기
		JSONObject obj = new JSONObject();
		obj.put("member", new JSONObject(member));
		/*
		 * {
		 *  	"member" : {
		 *  			"memberNo" : 회원번호,
		 *  			"id" : 아이디,
		 *  			"name" : 이름,
		 *  			...
		 *  	}
		 *  } 
		 */
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.flush();
		out.close();
	}

}
