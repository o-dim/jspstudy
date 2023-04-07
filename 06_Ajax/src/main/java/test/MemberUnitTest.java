package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Member;

import repository.MemberDAO;

public class MemberUnitTest {

	@BeforeClass // MemberUnitTest클래스(테스트파일) 실행 이전에 한 번 먼저 실행된다(static처리 필수)
	public static void 삽입테스트() {
		Member member = new Member(1, "admin", "관리자", "M", "seoul");
		assertEquals(1, MemberDAO.getInstance().insertMember(member));
	}
	@Test
	public void 목록테스트() {
		assertEquals(1, MemberDAO.getInstance().selectAllMembers().size());
	}
	@Test
	public void 상세테스트() {
		Member member = new Member(1, "admin", "관리자", "M", "seoul");
		assertEquals(member, MemberDAO.getInstance().selectMemberbyNo(1));
	}
	@Test
	public void 수정테스트() {
		Member member = new Member(1, null, "모나리자", "F", "seoul");
		assertEquals(1, MemberDAO.getInstance().updateMember(member));
	}
	@AfterClass
	public static void 삭제테스트() {
		assertEquals(1, MemberDAO.getInstance().deleteMember(1));
	}

}
