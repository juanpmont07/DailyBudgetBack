package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Mono<Category> register(Category category) {
        return Mono.fromCallable(()->categoryJpaRepository.save(category))
                .onErrorMap(ex->new DomainException("Error registering the category",ex));
    }

    @Override
    public Mono<List<Category>> getByUserId(UUID id) {
        List<Category> categories = categoryJpaRepository.findByUserInfoId(id);
        return categories.isEmpty() ? Mono.error(new DomainException("The client not has categories"))
                : Mono.just(categories);
    }

}