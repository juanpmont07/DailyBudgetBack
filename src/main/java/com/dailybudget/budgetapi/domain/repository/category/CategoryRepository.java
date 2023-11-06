package com.dailybudget.budgetapi.domain.repository.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    Mono<CategoryDTO> register(Category category);

    Mono<List<ConsultCategoryDTO>> getByUserId(UUID id);
}