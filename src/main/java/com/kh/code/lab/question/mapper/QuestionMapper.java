package com.kh.code.lab.question.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.code.lab.question.dto.RandomQuestionDto;
import com.kh.code.lab.question.vo.AttemptVo;

@Mapper
public interface QuestionMapper {

	RandomQuestionDto selectRandomQuestionExcept(@Param("currentQuestionNo") Long currentQuestionNo);
	
	RandomQuestionDto selectRandomQuestion();
	
	List<String> selectAnswerList(@Param("questionNo") long questionNo);
	
	int insertAttempt(AttemptVo attemptVo);
	
	List<String> selectWrongAnswerList(@Param("questionNo") long questionNo);
	
}
