package com.ariana.quiz.domain.dto;

import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.domain.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDto {
    private UUID id;
    private String title;
    private CategoryDto category;
    private List<QuestionDto> questions;
}
