package com.ariana.quiz.mappers;

import com.ariana.quiz.domain.dto.CategoryDto;
import com.ariana.quiz.domain.entities.Category;
import org.springframework.stereotype.Component;

@Component
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category fromDto(CategoryDto categoryDto);
}
