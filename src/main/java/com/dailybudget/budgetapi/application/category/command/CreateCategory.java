package com.dailybudget.budgetapi.application.category.command;

import com.dailybudget.budgetapi.application.shared.command.Command;
import com.dailybudget.budgetapi.application.category.command.service.CategoryService;
import com.dailybudget.budgetapi.infrastructure.category.adapters.mappers.CategoryMapper;
import com.dailybudget.budgetapi.domain.category.models.dto.CategoryDTO;
import com.dailybudget.budgetapi.domain.category.models.dto.RegisterCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateCategory implements Command<RegisterCategoryDTO, CategoryDTO> {

    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    @Override
    public Mono<CategoryDTO> execute(RegisterCategoryDTO dto) {
        return categoryService.registerCategory(categoryMapper.toDomain(dto));
    }
}