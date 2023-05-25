package com.dailybudget.budgetapi.infrastructure.adapters.mappers;

import com.dailybudget.budgetapi.domain.models.User;
import com.dailybudget.budgetapi.presentation.dtos.RegisterUserDTO;
import com.dailybudget.budgetapi.presentation.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(RegisterUserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSalary(dto.getSalary());
        user.setSavingRule(dto.getSavingRule());
        return user;
    }

    public UserDTO toDTO(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSalary(user.getSalary());
        userDto.setSavingRule(user.getSavingRule());
        return userDto;
    }

}

