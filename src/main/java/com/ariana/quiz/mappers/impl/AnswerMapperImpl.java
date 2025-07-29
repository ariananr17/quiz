package com.ariana.quiz.mappers.impl;

import com.ariana.quiz.domain.dto.AnswerDto;
import com.ariana.quiz.domain.entities.Answer;
import com.ariana.quiz.mappers.AnswerMapper;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapperImpl implements AnswerMapper {
    @Override
    public AnswerDto toDto(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(answer.getId());
        answerDto.setAnswer(answer.getAnswer());
        answerDto.setCorrect(answer.isCorrect());
        return answerDto;
    }

    @Override
    public AnswerDto fromDto(AnswerDto answerDto) {
        return null;
    }
}
