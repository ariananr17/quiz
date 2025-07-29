package com.ariana.quiz.domain.dto;


import com.ariana.quiz.domain.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuizRequest {

    private String title;

    private String category;

    private List<QuestionRequest> questions = new ArrayList<>();
}
