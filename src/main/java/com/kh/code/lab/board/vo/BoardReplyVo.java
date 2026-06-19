package com.kh.code.lab.board.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardReplyVo {
	
	private long replyNo;				//	REPLY_NO
	private long boardNo;				//	BOARD_NO
	private long memberNo;				//	MEMBER_NO
	private String replyContent;		//	REPLY_CONTENT
	private LocalDateTime createdAt;	//	CREATED_AT
	private LocalDateTime updatedAt;	//	UPDATED_AT
	private String Status;				//	STATUS
	
}
