package com.ariana.quiz.mappers.impl;

import com.ariana.quiz.domain.dto.CategoryDto;
import com.ariana.quiz.domain.dto.QuestionDto;
import com.ariana.quiz.domain.dto.QuizDto;
import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.domain.entities.Question;
import com.ariana.quiz.domain.entities.Quiz;
import com.ariana.quiz.mappers.CategoryMapper;
import com.ariana.quiz.mappers.QuestionMapper;
import com.ariana.quiz.mappers.QuizMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizMapperImpl implements QuizMapper {

    private final CategoryMapper categoryMapper;

    private final QuestionMapper questionMapper;

    @Override
    public QuizDto toDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        CategoryDto categoryDto = categoryMapper.toDto(quiz.getCategory());
        quizDto.setCategory(categoryDto);
        List<QuestionDto> questions = quiz.getQuestions().stream()
                .map(questionMapper::toDto).toList();
        quizDto.setQuestions(questions);
        return quizDto;
    }

    @Override
    public Quiz fromDto(QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDto.getTitle());
        Category category = categoryMapper.fromDto(quizDto.getCategory());
        quiz.setCategory(category);
        List<Question> questions = quizDto.getQuestions().stream()
                .map(questionMapper::fromDto).toList();
        quiz.setQuestions(questions);
        return quiz;
    }
}
