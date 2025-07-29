package com.ariana.quiz.mappers;

import com.ariana.quiz.domain.dto.QuestionDto;
import com.ariana.quiz.domain.entities.Question;

public interface QuestionMapper {
    QuestionDto toDto(Question question);
    Question fromDto(QuestionDto questionDto);
}
