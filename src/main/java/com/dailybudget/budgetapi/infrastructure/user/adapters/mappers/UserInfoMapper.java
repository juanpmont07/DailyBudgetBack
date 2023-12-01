package com.dailybudget.budgetapi.infrastructure.user.adapters.mappers;

import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import com.dailybudget.budgetapi.domain.user.models.dto.RegisterUserDTO;
import com.dailybudget.budgetapi.domain.user.models.dto.UserInfoDTO;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper {

    public UserInfo toDomain(RegisterUserDTO dto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(dto.getId());
        userInfo.setName(dto.getName());
        userInfo.setSalary(dto.getSalary());
        userInfo.setSavingRule(dto.getSavingRule());
        userInfo.setUserType(dto.getUserType());
        return userInfo;
    }

    public UserInfoDTO toDTO(UserInfoEntity userInfo) {
        UserInfoDTO userInfoDto = new UserInfoDTO();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setName(userInfo.getName());
        userInfoDto.setSalary(userInfo.getSalary());
        userInfoDto.setSavingRule(userInfo.getSavingRule());
        userInfoDto.setUserType(userInfo.getUserType());
        return userInfoDto;
    }

    public UserInfoEntity toEntity(UserInfo domain) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        if (domain!=null) {
            userInfoEntity.setId(domain.getId());
            userInfoEntity.setName(domain.getName());
            userInfoEntity.setUserType(domain.getUserType());
            userInfoEntity.setSalary(domain.getSalary());
            userInfoEntity.setSavingRule(domain.getSavingRule());
        }
        return userInfoEntity;
    }

    public UserInfoEntity toEntity(UserInfoDTO dto) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        if (dto!=null) {
            userInfoEntity.setId(dto.getId());
            userInfoEntity.setName(dto.getName());
            userInfoEntity.setUserType(dto.getUserType());
            userInfoEntity.setSalary(dto.getSalary());
            userInfoEntity.setSavingRule(dto.getSavingRule());
        }
        return userInfoEntity;
    }
}

