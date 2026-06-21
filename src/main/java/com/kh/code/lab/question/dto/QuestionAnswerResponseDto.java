package com.kh.code.lab.question.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QuestionAnswerResponseDto {

	private boolean success;
	private String message;
	private long questionNo;
	private List<String> answers;
	
	public static QuestionAnswerResponseDto fail(String message) {
		return new QuestionAnswerResponseDto(false, message, 0, List.of());
	}
	
}
