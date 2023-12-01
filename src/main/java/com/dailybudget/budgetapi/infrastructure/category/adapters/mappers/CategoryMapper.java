package com.dailybudget.budgetapi.infrastructure.category.adapters.mappers;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import com.dailybudget.budgetapi.domain.category.models.dto.CategoryDTO;
import com.dailybudget.budgetapi.domain.category.models.dto.ConsultCategoryDTO;
import com.dailybudget.budgetapi.domain.category.models.dto.RegisterCategoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category toDomain(RegisterCategoryDTO dto) {
        Category category = new Category();
        if (dto!=null) {
            category.setName(dto.getName());
            category.setUserId(dto.getUserId());
        }
        return category;
    }

    public CategoryEntity toEntity(Category domain) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (domain!=null) {
            categoryEntity.setName(domain.getName());
            categoryEntity.setUserInfo(new UserInfoEntity());
            categoryEntity.getUserInfo().setId(domain.getUserId());
        }
        return categoryEntity;
    }

    public CategoryDTO toDTO(CategoryEntity category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if(category!=null) {
            categoryDTO.setIdCategory(category.getId());
            categoryDTO.setCategoryName(category.getName());
            categoryDTO.setUserName(category.getUserInfo().getName());
            categoryDTO.setSavingRule(category.getUserInfo().getSavingRule());
        }
        return categoryDTO;
    }

    public List<ConsultCategoryDTO> toListDTO(List<CategoryEntity> categories) {
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