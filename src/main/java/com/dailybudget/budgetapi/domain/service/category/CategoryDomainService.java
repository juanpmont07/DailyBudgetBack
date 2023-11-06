package com.dailybudget.budgetapi.domain.service.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryDomainService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public Mono<CategoryEntity> registerCategory(Category category){
        return categoryRepository.register(category);
    }

    public Mono<List<CategoryEntity>> getCategoryByUserId(UUID userId){
        return categoryRepository.getByUserId(userId);
    }
}