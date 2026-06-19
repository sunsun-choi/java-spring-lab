package com.kh.code.lab.board.dto;

import com.kh.code.lab.common.pagination.PageQuery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardSearchCondition {
	
	private Integer categoryNo;
	private PageQuery pageQuery;
	
}
