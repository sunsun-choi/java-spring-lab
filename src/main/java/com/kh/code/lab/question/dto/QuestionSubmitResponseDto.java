package com.kh.code.lab.question.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QuestionSubmitResponseDto {

	private boolean success;
	private String message;
	private long questionNo;
	private boolean correct;
	private String resultMessage;
	private List<String> wrongAnswers;
	
	public static QuestionSubmitResponseDto fail(String message) {
		return new QuestionSubmitResponseDto(false, message, 0, false, null, List.of());
	}
	
}
