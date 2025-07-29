package com.ariana.quiz.mappers.impl;


import com.ariana.quiz.domain.dto.CategoryDto;
import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.mappers.CategoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        category.setQuizList(category.getQuizList());

        return categoryDto;
    }

    @Override
    public Category fromDto(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }
}
