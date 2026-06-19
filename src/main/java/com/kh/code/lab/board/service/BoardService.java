package com.kh.code.lab.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.code.lab.board.dto.BoardListItemDto;
import com.kh.code.lab.board.dto.BoardListResponseDto;
import com.kh.code.lab.board.dto.BoardSearchCondition;
import com.kh.code.lab.board.mapper.BoardMapper;
import com.kh.code.lab.common.pagination.PageCondition;
import com.kh.code.lab.common.pagination.PageInfo;
import com.kh.code.lab.common.pagination.PageQuery;
import com.kh.code.lab.common.pagination.Pagination;
import com.kh.code.lab.common.pagination.PaginationPolicy;

@Service
public class BoardService {

	//==[필드부]===========
	private BoardMapper bm;
	
	//==[메소드부]==========
	
	public BoardListResponseDto selectBoardList(int cpage, Integer categoryNo) {
		
		// 1. 게시글 목록 조회용 페이지 정보 생성
		int listCount = bm.selectBoardCount(categoryNo);
		PageQuery pageQuery = Pagination.createPageQuery(cpage, listCount);
		
		// 2. 게시글목록 조회
		List<BoardListItemDto> boardListItem 
				= bm.selectBoardList(new BoardSearchCondition(categoryNo, pageQuery));
		
		// 3. UI 용 페이징 정보 생성
		PaginationPolicy free = PaginationPolicy.FREE_BOARD;
		PageCondition pageCondition = PageCondition.builder()
									 .currentPage(cpage)
									 .listCount(listCount)
									 .pageBarSize(free.getPageBarSize())
									 .pageSize(free.getPageSize())
									 .build();
		PageInfo pageInfo = Pagination.createPageInfo(pageCondition);
		
		// 4. 컨트롤러로 반환
		return new BoardListResponseDto(boardListItem, pageInfo);
	}

}
