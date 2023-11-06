package com.dailybudget.budgetapi.infrastructure.adapters.mappers.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.RegisterCategoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category toEntity(RegisterCategoryDTO dto) {
        Category category = new Category();
        if (dto!=null) {
            category.setId(dto.getId());
            category.setName(dto.getName());
            category.setUserInfo(new UserInfo());
            category.getUserInfo().setId(dto.getUserId());
        }
        return category;
    }

    public CategoryDTO toDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if(category!=null) {
            categoryDTO.setIdCategory(category.getId());
            categoryDTO.setCategoryName(category.getName());
            categoryDTO.setUserName(category.getUserInfo().getName());
            categoryDTO.setSavingRule(category.getUserInfo().getSavingRule());
        }
        return categoryDTO;
    }

    public List<ConsultCategoryDTO> toListDTO(List<Category> categories) {
        List<ConsultCategoryDTO> consultCategoryDTO = new ArrayList<>();
        categories.forEach(category -> {
            ConsultCategoryDTO consult = new ConsultCategoryDTO();
            consult.setIdCategory(category.getId());
            consult.setCategoryName(category.getName());
            consultCategoryDTO.add(consult);
        });
        return consultCategoryDTO;
    }
}