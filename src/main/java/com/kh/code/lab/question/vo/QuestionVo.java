package com.kh.code.lab.question.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionVo {

	private long questionNo;			// QUESTION_NO
	private String subject;			// SUBJECT
	private String keyword;			// KEYWORD
	private LocalDateTime createdAt;	// CREATED_AT
	
}
