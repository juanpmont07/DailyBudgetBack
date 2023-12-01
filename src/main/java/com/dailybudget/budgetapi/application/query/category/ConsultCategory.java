package com.dailybudget.budgetapi.application.query.category;

import com.dailybudget.budgetapi.application.query.Query;
import com.dailybudget.budgetapi.application.service.category.CategoryService;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsultCategory implements Query<List<ConsultCategoryDTO>, UUID> {

    private final CategoryService categoryService;

    @Override
    public Mono<List<ConsultCategoryDTO>> execute(UUID userId) {
        return categoryService.getCategoryByUserId(userId);
    }
}
