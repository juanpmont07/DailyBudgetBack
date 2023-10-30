package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Mono<Category> getById(UUID id) {
        Optional<Category> categoryOptional = categoryJpaRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return Mono.just(categoryOptional.get());
        } else {
            return Mono.empty();
        }
    }

    @Override
    public Mono<Category> register(Category category) {
        try {
            Category savedCategory = categoryJpaRepository.save(category);
            return Mono.just(savedCategory);
        } catch (Exception ex) {
            return Mono.error(new DomainException("Error registering the category", ex));
        }
    }
}