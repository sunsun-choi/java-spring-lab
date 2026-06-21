package com.kh.code.lab.question.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.code.lab.question.dto.QuestionAnswerResponseDto;
import com.kh.code.lab.question.dto.QuestionSubmitRequestDto;
import com.kh.code.lab.question.dto.QuestionSubmitResponseDto;
import com.kh.code.lab.question.dto.RandomQuestionDto;
import com.kh.code.lab.question.mapper.QuestionMapper;
import com.kh.code.lab.question.vo.AttemptVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

	//==[필드부]===========
	private final QuestionMapper qm;
	
	//==[메소드부]==========
	
	@Transactional(readOnly = true)
	public RandomQuestionDto selectRandomQuestion(Long currentQuestionNo) {
		
		RandomQuestionDto question = null;
		
		if(currentQuestionNo != null) {
			question = qm.selectRandomQuestionExcept(currentQuestionNo);
		}
		
		if(question == null) {
			question = qm.selectRandomQuestion();
		}
		
		if(question == null) {
			return RandomQuestionDto.fail("등록된 문제가 없습니다.");
		}
		
		question.setSuccess(true);
		question.setMessage("문제 조회 성공");
		
		return question;
	}
	
	@Transactional
	public QuestionSubmitResponseDto submitAnswer(QuestionSubmitRequestDto requestDto) {
		
		if(requestDto == null || requestDto.getQuestionNo() <= 0) {
			return QuestionSubmitResponseDto.fail("문제 정보가 올바르지 않습니다.");
		}
		
		String inputAnswer = trim(requestDto.getInputAnswer());
		
		if(inputAnswer.isBlank()) {
			return QuestionSubmitResponseDto.fail("정답을 입력해주세요.");
		}
		
		List<String> answerList = qm.selectAnswerList(requestDto.getQuestionNo());
		
		if(answerList.isEmpty()) {
			return QuestionSubmitResponseDto.fail("등록된 정답이 없습니다.");
		}
		
		boolean correct = isCorrect(inputAnswer, answerList);
		String isCorrect = correct ? "Y" : "N";
		
		AttemptVo attemptVo = new AttemptVo();
		attemptVo.setQuestionNo(requestDto.getQuestionNo());
		attemptVo.setInputAnswer(inputAnswer);
		attemptVo.setIsCorrect(isCorrect);
		
		qm.insertAttempt(attemptVo);
		
		List<String> wrongAnswerList = qm.selectWrongAnswerList(requestDto.getQuestionNo());
		String resultMessage = correct ? "정답입니다." : "오답입니다.";
		
		return new QuestionSubmitResponseDto(true, "채점 완료", requestDto.getQuestionNo()
											 , correct, resultMessage, wrongAnswerList);
	}
	
	@Transactional(readOnly = true)
	public QuestionAnswerResponseDto selectAnswerResponse(long questionNo) {
		
		if(questionNo <= 0) {
			return QuestionAnswerResponseDto.fail("문제 정보가 올바르지 않습니다.");
		}
		
		List<String> answerList = qm.selectAnswerList(questionNo)
									.stream()
									.map(this::trim)
									.distinct()
									.toList();
		
		if(answerList.isEmpty()) {
			return QuestionAnswerResponseDto.fail("등록된 정답이 없습니다.");
		}
		
		return new QuestionAnswerResponseDto(true, "정답 조회 성공", questionNo, answerList);
	}
	
	private boolean isCorrect(String inputAnswer, List<String> answerList) {
		
		for(String answer : answerList) {
			if(inputAnswer.equals(trim(answer))) {
				return true;
			}
		}
		
		return false;
	}
	
	private String trim(String value) {
		return value == null ? "" : value.trim();
	}
	
}
