package com.ariana.quiz.mappers;

import com.ariana.quiz.domain.dto.AnswerDto;
import com.ariana.quiz.domain.entities.Answer;

public interface AnswerMapper {
    AnswerDto toDto(Answer answer);
    AnswerDto fromDto(AnswerDto answerDto);
}
