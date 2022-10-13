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
	//�� ���
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	//�� ����
	@RequestMapping("/updateBoard.do")
	public String updateBoart(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("�ۼ��� �̸� :" + vo.getWriter());
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	//�� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBaord(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	//�� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo)); //Model ���� ����
		return "getBoard.jsp"; //View �̸� ����
	}
	
	//�� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		//Model ���� ����
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp"; //View �̸� ����
	}
}