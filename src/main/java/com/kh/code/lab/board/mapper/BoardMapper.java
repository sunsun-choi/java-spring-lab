package com.kh.code.lab.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.code.lab.board.dto.BoardListItemDto;
import com.kh.code.lab.board.dto.BoardSearchCondition;

@Mapper
public interface BoardMapper {

	
	int selectBoardCount(@Param("categoryNo") Integer categoryNo);
	
	List<BoardListItemDto> selectBoardList(BoardSearchCondition boardSearchCondition);

	
	
	 
	 
}
