package com.kh.code.lab.question.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class QuestionSubmitRequestDto {

	private long questionNo;
	private String inputAnswer;
	
}
