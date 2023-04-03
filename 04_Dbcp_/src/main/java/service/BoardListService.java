package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardListService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 1. BoardDAO 객체 준비
		BoardDAO dao = BoardDAO.getInstance();
		
		// 2. BoardDAO 의 selectBoardList 메소드 호출 (DB로부터 게시글 목록가져오기 )
		List<BoardDTO> boardList = dao.selectBoardList();
		
		// 3. DB로 부터 가져온 게시글목록 boardList 를 request에 저장(forward 하기 위해서 )
		request.setAttribute("boardList", boardList);
		
		// 4. 어디로 어떻게 이동할 것인가
		ActionForward af = new ActionForward("board/list.jsp", false); // board폴더 아래 list.jsp로 이동
		
		return af;
	}

}
