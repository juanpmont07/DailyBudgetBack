package com.dailybudget.budgetapi.infrastructure.movements.adapters.mappers;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.movements.models.entities.Movement;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.category.adapters.mappers.CategoryMapper;
import com.dailybudget.budgetapi.infrastructure.movements.adapters.entities.MovementsEntity;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserInfoMapper;
import org.springframework.stereotype.Component;

@Component
public class MovementsMapper {

    public Movement toDomain(MovementsEntity entity) {
        Category category = new CategoryMapper().toDomain(entity.getCategory());
        UserInfo userInfo = new UserInfoMapper().toDomain(entity.getUser());
        return Movement.rebuild(entity.getId(), entity.getDescription(), entity.getDate(), category, entity.getValue(), userInfo, null);
    }
}
