package com.ariana.quiz.services;


import com.ariana.quiz.domain.dto.CreateQuizRequest;
import com.ariana.quiz.domain.entities.Quiz;

import java.util.List;
import java.util.UUID;

public interface QuizService {
    Quiz createQuiz(CreateQuizRequest createQuizRequest);

    List<Quiz> findAllByCategoryId(UUID categoryId);

    List<Quiz> findAll(int size);

    Quiz getQuiz(UUID id);

    void deleteById(UUID id);

    List<Quiz> findByCategoryId(UUID categoryId);
}
