package com.ariana.quiz.services.impl;

import com.ariana.quiz.domain.dto.CategoryDto;
import com.ariana.quiz.domain.dto.CreateQuizRequest;
import com.ariana.quiz.domain.entities.Answer;
import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.domain.entities.Question;
import com.ariana.quiz.domain.entities.Quiz;
import com.ariana.quiz.mappers.CategoryMapper;
import com.ariana.quiz.repositories.CategoryRepository;
import com.ariana.quiz.repositories.QuizRepository;
import com.ariana.quiz.services.QuizService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public Quiz createQuiz(CreateQuizRequest createQuizRequest) {
        Quiz newQuiz = new Quiz();
        newQuiz.setTitle(createQuizRequest.getTitle());
        Optional<Category> categoryOpt = categoryRepository.findByName(createQuizRequest.getCategory());
        if(categoryOpt.isPresent()){
            Category category = categoryOpt.get();
            newQuiz.setCategory(category);
        }else {
            Category category = Category.builder()
                    .name(createQuizRequest.getCategory())
                    .build();
            categoryRepository.save(category);
            newQuiz.setCategory(category);
        }

        List<Question> questions = createQuizRequest.getQuestions()
                .stream()
                .map(questionRequest -> {
                    Question question = new Question();
                    question.setQuestion(questionRequest.getQuestion());

                    List<Answer> answers = questionRequest.getAnswers().stream()
                            .map(answerRequest -> {
                                Answer answer = new Answer();
                                answer.setAnswer(answerRequest.getAnswer());
                                answer.setCorrect(answerRequest.isCorrect());
                                answer.setQuestion(question);
                                return answer;
                            })
                            .toList();
                    question.setAnswers(answers);
                    //answers.stream().forEach(answer -> question.getAnswers().add(answer));
                    question.setQuiz(newQuiz);
                    return question;
                })
                .toList();

        newQuiz.setQuestions(questions);

        return quizRepository.save(newQuiz);
    }

    @Override
    public List<Quiz> findAllByCategoryId(UUID categoryId) {
        return quizRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Quiz> findAll(int size) {
        Pageable pageable = PageRequest.of(0, size);
        return quizRepository.findAll(pageable).getContent();
    }

    @Override
    public Quiz getQuiz(UUID id) {
        return quizRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public void deleteById(UUID id) {
        quizRepository.deleteById(id);
    }

    @Override
    public List<Quiz> findByCategoryId(UUID categoryId) {
        return quizRepository.findAllByCategoryId(categoryId);
    }


}
