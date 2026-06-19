package com.kh.code.lab.board.dto;

import java.util.List;

import com.kh.code.lab.common.pagination.PageInfo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardListResponseDto {
	
	private List<BoardListItemDto> boardListItem;
	private PageInfo pageInfo;

}
