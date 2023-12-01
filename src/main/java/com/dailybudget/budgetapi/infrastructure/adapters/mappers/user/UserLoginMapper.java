package com.dailybudget.budgetapi.infrastructure.adapters.mappers.user;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserLoginEntity;
import com.dailybudget.budgetapi.presentation.dtos.user.UserLoginDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterLoginDTO;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public UserLogin toDomain(RegisterLoginDTO dto) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(dto.getUserId());
        userLogin.setUsername(dto.getUsername());
        userLogin.setPassword(dto.getPassword());
        return userLogin;
    }

    public UserLoginDTO toDTO(UserLoginEntity userLogin) {
        UserLoginDTO login = new UserLoginDTO();
        login.setName(userLogin.getUserInfo().getName());
        login.setUserType(userLogin.getUserInfo().getUserType());
        login.setAccessToken("access token generate successful");
        return login;
    }

    public UserLoginEntity toEntity(UserLogin domain) {
        UserLoginEntity userLogin = new UserLoginEntity();
        userLogin.setUserId(domain.getUserId());
        userLogin.setUsername(domain.getUsername());
        userLogin.setPassword(domain.getPassword());
        return userLogin;
    }

}
