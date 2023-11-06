package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.repository.category.CategoryRepository;
import com.dailybudget.budgetapi.domain.utils.ErrorCode;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.category.CategoryMapper;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
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
    public Mono<CategoryDTO> register(Category category) {
        return Mono.fromCallable(()->categoryJpaRepository.save(categoryMapper.toEntity(category)))
                .map(categoryMapper::toDTO)
                .onErrorMap(ex->new DomainException(ErrorCode.CATEGORY_WAS_NOT_REGISTERED,ex));
    }

    @Override
    public Mono<List<ConsultCategoryDTO>> getByUserId(UUID id) {
        return Mono.fromCallable(()->categoryJpaRepository.findByUserInfoId(id))
                .map(categoryMapper::toListDTO)
                .switchIfEmpty(Mono.empty())
                .onErrorMap(ex->new DomainException(ErrorCode.CATEGORY_NOT_FOUND,ex));
    }

}