package com.dailybudget.budgetapi.application.category.query;

import com.dailybudget.budgetapi.application.shared.query.Query;
import com.dailybudget.budgetapi.application.category.command.service.CategoryService;
import com.dailybudget.budgetapi.domain.category.models.dto.ConsultCategoryDTO;
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
