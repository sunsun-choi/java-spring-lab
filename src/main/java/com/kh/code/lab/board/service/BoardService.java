package com.kh.code.lab.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.code.lab.board.dto.BoardListItemDto;
import com.kh.code.lab.board.dto.BoardListResponseDto;
import com.kh.code.lab.board.dto.BoardSearchCondition;
import com.kh.code.lab.board.mapper.BoardMapper;
import com.kh.code.lab.common.pagination.PageCondition;
import com.kh.code.lab.common.pagination.PageInfo;
import com.kh.code.lab.common.pagination.PageQuery;
import com.kh.code.lab.common.pagination.Pagination;
import com.kh.code.lab.common.pagination.PaginationPolicy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	//==[필드부]===========
	private final BoardMapper bm;
	
	//==[메소드부]==========
	
	@Transactional(readOnly = true)
	public BoardListResponseDto selectBoardList(int cpage, Integer categoryNo) {
		
		// 1. 게시글 목록 조회용 페이지 정보 생성
		int listCount = bm.selectBoardCount(categoryNo);
		PageQuery pageQuery = Pagination.createPageQuery(cpage, listCount);
		
		// 2-1. 게시글목록 조회
		List<BoardListItemDto> boardListItem 
				= bm.selectBoardList(new BoardSearchCondition(categoryNo, pageQuery));
		// 2-2. 닉네임 마스킹처리
		for(BoardListItemDto b : boardListItem) {
			b.setNickName(maskNickname(b.getNickName()));
		}
		
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
	
	
	/** 3글자 이상의 닉네임을 앞의 3글자만 보이도록 마스킹해주는 메소드
	 * @param nickname String 형식의 바꿀닉네임
	 * @return '123****' 형식으로 마스킹된 닉네임
	 */
	public String maskNickname(String nickname) {
		
		
		if(nickname.length()<3) { return nickname; }
		
		String maskNickname = nickname.substring(0, 3) + "*".repeat((nickname.length()-3));
		
		return maskNickname;
	}
	
	
	
	

}
