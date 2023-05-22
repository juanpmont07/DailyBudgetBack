package com.dailybudget.budgetapi.infrastructure.adapters.mappers;

import com.dailybudget.budgetapi.domain.models.User;
import com.dailybudget.budgetapi.presentation.dtos.RegisterUserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterUserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSalary(dto.getSalary());
        user.setSavingRule(dto.getSavingRule());
        user.setUserId(dto.getUserId());
        return user;
    }

}

