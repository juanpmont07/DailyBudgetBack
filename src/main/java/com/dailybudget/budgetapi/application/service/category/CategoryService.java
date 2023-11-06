package com.dailybudget.budgetapi.application.service.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.service.category.CategoryDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoService;
import com.dailybudget.budgetapi.domain.utils.ErrorCode;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
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
    public UserInfoService userInfoService;
    @Autowired
    public CategoryDomainService categoryDomainService;

    public Mono<CategoryEntity> registerCategory(Category category){
        return userInfoService.getUserInfoById(category.getUserId())
                .switchIfEmpty(Mono.error(new DomainException(ErrorCode.USER_WAS_NOT_FOUND)))
                .flatMap(userInfo -> categoryDomainService.registerCategory(category));
    }

    public Mono<List<CategoryEntity>> getCategoryByUserId(UUID categoryId){
        return categoryDomainService.getCategoryByUserId(categoryId)
                .switchIfEmpty(Mono.error(new DomainException(ErrorCode.CATEGORY_WAS_NOT_REGISTERED))) ;
    }

}