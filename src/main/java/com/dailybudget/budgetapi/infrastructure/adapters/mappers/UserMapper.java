package com.dailybudget.budgetapi.infrastructure.adapters.mappers;

import com.dailybudget.budgetapi.domain.models.UserInfo;
import com.dailybudget.budgetapi.presentation.dtos.RegisterUserDTO;
import com.dailybudget.budgetapi.presentation.dtos.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserInfo toEntity(RegisterUserDTO dto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(dto.getId());
        userInfo.setName(dto.getName());
        userInfo.setSalary(dto.getSalary());
        userInfo.setSavingRule(dto.getSavingRule());
        return userInfo;
    }

    public UserDTO toDTO(UserInfo userInfo) {
        UserDTO userDto = new UserDTO();
        userDto.setId(userInfo.getId());
        userDto.setName(userInfo.getName());
        userDto.setSalary(userInfo.getSalary());
        userDto.setSavingRule(userInfo.getSavingRule());
        return userDto;
    }

}

