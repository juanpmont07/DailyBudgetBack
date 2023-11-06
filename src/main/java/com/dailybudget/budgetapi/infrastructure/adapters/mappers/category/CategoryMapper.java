package com.dailybudget.budgetapi.infrastructure.adapters.mappers.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserInfoEntity;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.RegisterCategoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category toDomain(RegisterCategoryDTO dto) {
        Category category = new Category();
        if (dto!=null) {
            category.setId(dto.getId());
            category.setName(dto.getName());
            category.setUserId(dto.getUserId());
        }
        return category;
    }

    public CategoryEntity toEntity(Category domain) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (domain!=null) {
            categoryEntity.setId(domain.getId());
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