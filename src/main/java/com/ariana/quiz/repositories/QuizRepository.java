package com.ariana.quiz.repositories;

import com.ariana.quiz.domain.dto.CreateQuizRequest;
import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.domain.entities.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, UUID> {

    List<Quiz> findAllByCategoryId(UUID categoryId);

    Page<Quiz> findAll(Pageable pageable);
}
