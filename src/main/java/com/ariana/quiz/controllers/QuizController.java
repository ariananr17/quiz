package com.ariana.quiz.controllers;

import com.ariana.quiz.domain.dto.CreateQuizRequest;
import com.ariana.quiz.domain.dto.QuizDto;
import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.domain.entities.Quiz;
import com.ariana.quiz.mappers.QuizMapper;
import com.ariana.quiz.services.CategoryService;
import com.ariana.quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/quiz")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    private final QuizMapper quizMapper;

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAllQuizzes(@RequestParam(value = "size", defaultValue = "8") int size) {
        List<Quiz> allQuizzes = quizService.findAll(size);
        List<QuizDto> allQuizzesDto = allQuizzes.stream().map(quizMapper::toDto).toList();
        return ResponseEntity.ok(allQuizzesDto);
    }

    @PostMapping
    public ResponseEntity<QuizDto> createQuiz(@RequestBody CreateQuizRequest createQuizRequest) {
        Quiz newQuiz = quizService.createQuiz(createQuizRequest);
        QuizDto quizDto =  quizMapper.toDto(newQuiz);
        return ResponseEntity.ok(quizDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable UUID id) {
        Quiz quiz = quizService.getQuiz(id);
        QuizDto quizDto = quizMapper.toDto(quiz);
        return ResponseEntity.ok(quizDto);
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<QuizDto>> getQuizzesByCategory(
            @RequestParam(required = false) UUID categoryId
    ) {
        List<Quiz> quizzes = quizService.findByCategoryId(categoryId);
        List<QuizDto> quizzesDto = quizzes.stream().map(quizMapper::toDto).toList();
        return ResponseEntity.ok(quizzesDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteQuiz(@RequestParam UUID quizId) {
        quizService.deleteById(quizId);
        return ResponseEntity.noContent().build();
    }
}


