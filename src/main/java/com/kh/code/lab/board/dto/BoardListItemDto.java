package com.kh.code.lab.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardListItemDto {
	
	private long boardNo;				//	BOARD_NO
	private int categoryNo;				//	CATEGORY_NO
	private String title;				//	TITLE
	private String nickName;			//	NICK_NAME
	private LocalDateTime createdAt;	//	CREATED_AT
	private int replyCount;				//  댓글수
}
