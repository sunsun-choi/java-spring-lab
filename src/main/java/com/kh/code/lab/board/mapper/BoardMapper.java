package com.kh.code.lab.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.code.lab.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	
	List<BoardDto> selectBoardList();
	 
	 
}
