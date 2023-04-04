package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardAddService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청 파라미터
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// BoardDTO 객체 생성하기
		BoardDTO board = new BoardDTO();
		board.setTitle(title);
		board.setContent(content);
		
		// DB로 BoardDTO를 전달 (데이터 삽입을 위해서)
		int insertResult = BoardDAO.getInstance().insertBoard(board);
		System.out.println(insertResult == 1 ? "삽입완료" : "삽입실패");
		// 어디로 and 어떻게 이동
		return new ActionForward(request.getContextPath() + "/getAllBoardList.do", true);
	}

}
