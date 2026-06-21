package com.kh.code.lab.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.code.lab.question.dto.QuestionAnswerResponseDto;
import com.kh.code.lab.question.dto.QuestionSubmitRequestDto;
import com.kh.code.lab.question.dto.QuestionSubmitResponseDto;
import com.kh.code.lab.question.dto.RandomQuestionDto;
import com.kh.code.lab.question.service.QuestionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

	//==[필드부]===========
	private final QuestionService qs;
	
	//==[메소드부]==========
	
	@GetMapping("")
	public String questionMain() {
		return "question/main";
	}
	
	@GetMapping("/solve")
	public String solveQuestion() {
		return "question/solve";
	}
	
	@ResponseBody
	@GetMapping("/random")
	public RandomQuestionDto selectRandomQuestion(@RequestParam(value="currentQuestionNo", required=false) Long currentQuestionNo) {
		return qs.selectRandomQuestion(currentQuestionNo);
	}
	
	@ResponseBody
	@PostMapping("/submit")
	public QuestionSubmitResponseDto submitAnswer(@RequestBody QuestionSubmitRequestDto requestDto) {
		return qs.submitAnswer(requestDto);
	}
	
	@ResponseBody
	@GetMapping("/answer")
	public QuestionAnswerResponseDto selectAnswer(@RequestParam("questionNo") long questionNo) {
		return qs.selectAnswerResponse(questionNo);
	}
	
}
