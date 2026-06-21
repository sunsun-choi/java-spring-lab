package com.kh.code.lab.question.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttemptVo {

	private long attemptNo;			// ATTEMPT_NO
	private long questionNo;			// QUESTION_NO
	private String inputAnswer;		// INPUT_ANSWER
	private String isCorrect;		// IS_CORRECT
	private LocalDateTime createdAt;	// CREATED_AT
	
}
