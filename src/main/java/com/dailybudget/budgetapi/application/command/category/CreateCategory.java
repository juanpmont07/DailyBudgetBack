package com.dailybudget.budgetapi.application.command.category;

import com.dailybudget.budgetapi.application.command.Command;
import com.dailybudget.budgetapi.application.service.category.CategoryService;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.category.CategoryMapper;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.RegisterCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateCategory implements Command<RegisterCategoryDTO, CategoryDTO> {

    @Autowired
    private final CategoryMapper categoryMapper;
    @Autowired
    private final CategoryService categoryService;

    @Override
    public Mono<CategoryDTO> execute(RegisterCategoryDTO dto) {
        return categoryService.registerCategory(categoryMapper.toEntity(dto)).map(categoryMapper::toDTO);
    }
}