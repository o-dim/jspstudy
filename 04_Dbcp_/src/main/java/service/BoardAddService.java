package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class BoardAddService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// BoardDAO 의 getInstance() 호출하기 
		/*
		 * 메소드 호
		 * 
		 * 객체로 호출하기 
		 * 불가넝.
		 * 
		 * 클래스로 호출하기
		 * 클래스.메소드()
		 * 
		 * */
		BoardDAO.getInstance();
		return null;
	}

}
