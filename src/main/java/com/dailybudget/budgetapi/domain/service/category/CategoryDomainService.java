package com.dailybudget.budgetapi.domain.service.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryDomainService {


    @Autowired
    private final CategoryRepository categoryRepository;

    public Mono<Category> registerCategory(Category category){
        return categoryRepository.register(category);
    }

    public Mono<Category> getCategoryById(UUID categoryId){
        return categoryRepository.getById(categoryId);
    }
}