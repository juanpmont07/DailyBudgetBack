package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import com.dailybudget.budgetapi.domain.utils.ErrorCode;
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

    @Override
    public Mono<Category> register(Category category) {
        return Mono.fromCallable(()->categoryJpaRepository.save(category))
                .onErrorMap(ex->new DomainException(ErrorCode.CATEGORY_WAS_NOT_REGISTERED,ex));
    }

    @Override
    public Mono<List<Category>> getByUserId(UUID id) {
        return Mono.fromCallable(()->categoryJpaRepository.findByUserInfoId(id))
                .onErrorMap(ex->new DomainException(ErrorCode.CATEGORY_NOT_FOUND,ex));
    }

}