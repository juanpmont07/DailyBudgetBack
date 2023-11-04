package com.dailybudget.budgetapi.application.service.category;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.service.category.CategoryDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    public UserInfoService userInfoService;
    @Autowired
    public CategoryDomainService categoryDomainService;

    public Mono<Category> registerCategory(Category category){
        return userInfoService.getUserInfoById(category.getUserInfo().getId())
                .switchIfEmpty(Mono.error(new DomainException("User is not register")))
                .flatMap(userInfo -> categoryDomainService.registerCategory(category));
    }

    public Mono<Category> getCategoryByUserId(UUID categoryId){
        return categoryDomainService.getCategoryById(categoryId)
                .switchIfEmpty(Mono.error(new DomainException("The category is not register"))) ;
    }

}