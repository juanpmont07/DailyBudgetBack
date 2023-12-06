package com.dailybudget.budgetapi.domain.category.service;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.category.port.CategoryRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class CategoryDomainService {

    private final CategoryRepository categoryRepository;

    public CategoryDomainService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Mono<Category> registerCategory(Category category){
        return categoryRepository.register(category);
    }

    public Mono<List<Category>> getCategoryByUserId(UUID userId){
        return categoryRepository.getByUserId(userId);
    }
}