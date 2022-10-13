package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	//글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoart(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("작성자 이름 :" + vo.getWriter());
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBaord(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo)); //Model 정보 저장
		return "getBoard.jsp"; //View 이름 리턴
	}
	
	//글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		//Model 정보 저장
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp"; //View 이름 리턴
	}
}