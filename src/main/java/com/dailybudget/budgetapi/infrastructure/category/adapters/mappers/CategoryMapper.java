package com.dailybudget.budgetapi.infrastructure.category.adapters.mappers;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import com.dailybudget.budgetapi.domain.category.models.dto.CategoryDTO;
import com.dailybudget.budgetapi.domain.category.models.dto.ConsultCategoryDTO;
import com.dailybudget.budgetapi.domain.category.models.dto.RegisterCategoryDTO;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserInfoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public Category toDomain(RegisterCategoryDTO dto) {
        UserInfo userInfo = UserInfo.rebuild(dto.getUserId());
        return Category.create(dto.getName(), userInfo);
    }

    public Category toDomain(CategoryEntity dto) {
        UserInfo userInfo = new UserInfoMapper().toDomain(dto.getUserInfo());
        return Category.create(dto.getName(), userInfo);
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