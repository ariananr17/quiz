package com.ariana.quiz.controllers;

import com.ariana.quiz.domain.dto.CategoryDto;
import com.ariana.quiz.domain.entities.Category;
import com.ariana.quiz.mappers.CategoryMapper;
import com.ariana.quiz.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {
       List<Category> categories = categoryService.getAllCategories();
       List <CategoryDto> categoriesDto = categories.stream().map(categoryMapper::toDto).toList();
       return ResponseEntity.ok(categoriesDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
