package com.dailybudget.budgetapi.domain.repository.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    Mono<CategoryEntity> register(Category category);

    Mono<List<CategoryEntity>> getByUserId(UUID id);
}