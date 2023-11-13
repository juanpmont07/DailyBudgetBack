package com.dailybudget.budgetapi.application.service.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.service.category.CategoryDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.category.CategoryMapper;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
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