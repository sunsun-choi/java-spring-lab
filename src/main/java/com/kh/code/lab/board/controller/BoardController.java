package com.kh.code.lab.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.code.lab.board.dto.BoardListResponseDto;
import com.kh.code.lab.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	//==[필드부]===========
	
	@Autowired
	private BoardService bs;
	
	//==[메소드부]==========
	
	@GetMapping("")
	public String selectBoardList(@RequestParam(value="cpage", defaultValue="1")int cpage
								, @RequestParam(value="categoryNo", required=false)Integer categoryNo
								, Model model) {
		
		// =================================== [게시판 목록 조회(자유게시판)] ============
		// 학습 목적: 닉네임 마스킹 처리
		// 구현 기능: 페이징, 글 카테고리 필터
		// 제외 기능: 검색
		// 참고 사항: 사용하지 않는 카테고리의 글일 경우 조회 가능, 해당 카테고리로 새 글 작성 불가능
		// =========================================================================
		
		
		BoardListResponseDto boardList = bs.selectBoardList(cpage, categoryNo);
		
		model.addAttribute("boardList",boardList);
		return "board/list";
	}
	
	
	
	
	
}
