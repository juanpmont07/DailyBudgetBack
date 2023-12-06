package com.dailybudget.budgetapi.infrastructure.category.adapters.repositories;

import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.category.port.CategoryRepository;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.category.adapters.mappers.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private final CategoryJpaRepository categoryJpaRepository;

    @Autowired
    private final CategoryMapper categoryMapper;


    @Override
    public Mono<Category> register(Category category) {
        return Mono.fromCallable(()->categoryMapper.toDomain(categoryJpaRepository.save(categoryMapper.toEntity(category))))
                .onErrorMap(ex->new DomainException(ex.getMessage(), StatusCode.CATEGORY_WAS_NOT_REGISTERED,ex));
    }

    @Override
    public Mono<List<Category>> getByUserId(UUID id) {
        return Mono.fromCallable(() ->
                categoryJpaRepository.findByUserInfoId(id)
                        .stream()
                        .map(categoryMapper::toDomain)
                        .collect(Collectors.toList())
        ).onErrorMap(ex -> new DomainException(ex.getMessage(), StatusCode.CATEGORY_NOT_FOUND, ex));
    }


}