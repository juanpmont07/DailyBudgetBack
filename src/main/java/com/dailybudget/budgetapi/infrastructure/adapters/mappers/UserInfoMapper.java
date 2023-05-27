package com.dailybudget.budgetapi.infrastructure.adapters.mappers;

import com.dailybudget.budgetapi.domain.models.UserInfo;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterUserDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    public UserInfo toEntity(RegisterUserDTO dto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(dto.getId());
        userInfo.setName(dto.getName());
        userInfo.setSalary(dto.getSalary());
        userInfo.setSavingRule(dto.getSavingRule());
        return userInfo;
    }

    public UserInfoDTO toDTO(UserInfo userInfo) {
        UserInfoDTO userInfoDto = new UserInfoDTO();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setName(userInfo.getName());
        userInfoDto.setSalary(userInfo.getSalary());
        userInfoDto.setSavingRule(userInfo.getSavingRule());
        return userInfoDto;
    }

}

