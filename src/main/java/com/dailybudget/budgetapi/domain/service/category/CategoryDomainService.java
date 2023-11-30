package com.dailybudget.budgetapi.domain.service.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public class CategoryDomainService {

    private final CategoryRepository categoryRepository;

    public CategoryDomainService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Mono<CategoryEntity> registerCategory(Category category){
        return categoryRepository.register(category);
    }

    public Mono<List<CategoryEntity>> getCategoryByUserId(UUID userId){
        return categoryRepository.getByUserId(userId);
    }
}