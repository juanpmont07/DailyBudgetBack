package com.dailybudget.budgetapi.domain.category.port;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    Mono<CategoryEntity> register(Category category);

    Mono<List<CategoryEntity>> getByUserId(UUID id);
}