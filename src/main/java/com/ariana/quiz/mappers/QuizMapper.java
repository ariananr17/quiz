package com.ariana.quiz.mappers;

import com.ariana.quiz.domain.dto.QuizDto;
import com.ariana.quiz.domain.entities.Quiz;

public interface QuizMapper {
    QuizDto toDto(Quiz quiz);
    Quiz fromDto(QuizDto quizDto);
}
