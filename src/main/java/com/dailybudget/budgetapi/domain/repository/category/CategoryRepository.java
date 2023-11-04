package com.dailybudget.budgetapi.domain.repository.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    Mono<Category> register(Category category);

    Mono<List<Category>> getByUserId(UUID id);
}