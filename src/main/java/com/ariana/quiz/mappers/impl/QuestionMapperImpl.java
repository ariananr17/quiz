package com.ariana.quiz.mappers.impl;

import com.ariana.quiz.domain.dto.AnswerDto;
import com.ariana.quiz.domain.dto.QuestionDto;
import com.ariana.quiz.domain.entities.Answer;
import com.ariana.quiz.domain.entities.Question;
import com.ariana.quiz.mappers.QuestionMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapperImpl implements QuestionMapper {
    @Override
    public QuestionDto toDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setQuestion(question.getQuestion());
        List<AnswerDto> answers = question.getAnswers().stream()
                .map(answer -> {
                    AnswerDto answerDto = new AnswerDto();
                    answerDto.setId(answer.getId());
                    answerDto.setAnswer(answer.getAnswer());
                    answerDto.setCorrect(answer.isCorrect());
                    return answerDto;
                })
                .toList();
        questionDto.setAnswers(answers);
        return questionDto;
    }

    @Override
    public Question fromDto(QuestionDto questionDto) {
        return null;
    }
}
