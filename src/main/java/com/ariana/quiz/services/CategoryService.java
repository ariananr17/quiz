package com.ariana.quiz.services;

import com.ariana.quiz.domain.entities.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    Optional<Category> findByName(String name);

    List<Category> getAllCategories();

    Category getCategory(UUID categoryId);

    void deleteCategory(UUID id);
}
