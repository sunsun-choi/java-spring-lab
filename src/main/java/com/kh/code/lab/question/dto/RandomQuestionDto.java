package com.kh.code.lab.question.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RandomQuestionDto {

	private boolean success;
	private String message;
	private Long questionNo;		// QUESTION_NO
	private String subject;		// SUBJECT
	private String keyword;		// KEYWORD
	
	public static RandomQuestionDto fail(String message) {
		RandomQuestionDto dto = new RandomQuestionDto();
		dto.setSuccess(false);
		dto.setMessage(message);
		return dto;
	}
	
}
