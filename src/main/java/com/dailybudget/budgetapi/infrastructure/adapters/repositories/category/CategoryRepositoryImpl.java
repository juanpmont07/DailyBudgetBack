package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import com.dailybudget.budgetapi.domain.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private final CategoryJpaRepository categoryJpaRepository;

    @Autowired
    private final CategoryMapper categoryMapper;


    @Override
    public Mono<CategoryEntity> register(Category category) {
        return Mono.fromCallable(()->categoryJpaRepository.save(categoryMapper.toEntity(category)))
                .onErrorMap(ex->new DomainException(ex.getMessage(), StatusCode.CATEGORY_WAS_NOT_REGISTERED,ex));
    }

    @Override
    public Mono<List<CategoryEntity>> getByUserId(UUID id) {
        return Mono.fromCallable(()->categoryJpaRepository.findByUserInfoId(id))
                .onErrorMap(ex->new DomainException(ex.getMessage(), StatusCode.CATEGORY_NOT_FOUND,ex));
    }

}