package com.dailybudget.budgetapi.application.category.command.service;

import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.category.service.CategoryDomainService;
import com.dailybudget.budgetapi.domain.user.service.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.category.adapters.mappers.CategoryMapper;
import com.dailybudget.budgetapi.domain.category.models.dto.CategoryDTO;
import com.dailybudget.budgetapi.domain.category.models.dto.ConsultCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    public UserInfoDomainService userInfoDomainService;
    @Autowired
    public CategoryDomainService categoryDomainService;
    @Autowired
    public CategoryMapper categoryMapper;

    public Mono<CategoryDTO> registerCategory(Category category){
        return userInfoDomainService.getUserInfoById(category.getUserId())
                .switchIfEmpty(Mono.error(new DomainException(StatusCode.USER_WAS_NOT_FOUND)))
                .flatMap(userInfo -> categoryDomainService.registerCategory(category)
                        .map(categoryMapper::toDTO));
    }

    public Mono<List<ConsultCategoryDTO>> getCategoryByUserId(UUID categoryId){
        return categoryDomainService.getCategoryByUserId(categoryId)
                .map(categoryMapper::toListDTO)
                .switchIfEmpty(Mono.error(new DomainException(StatusCode.CATEGORY_WAS_NOT_REGISTERED))) ;
    }

}