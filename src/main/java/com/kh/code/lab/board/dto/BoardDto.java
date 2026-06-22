package com.kh.code.lab.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardDto {

	private long boardNo;					//	BOARD_NO
	private String title;					//	TITLE
	private String content;					//	CONTENT
	private long categoryNo;				//	CATEGORY_NO
	private long memberNo;					//	MEMBER_NO
	private LocalDateTime createdAt;		//	CREATED_AT
	private LocalDateTime updatedAt;		//	UPDATED_AT
	
}
