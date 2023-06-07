package com.dailybudget.budgetapi.infrastructure.adapters.mappers;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.presentation.dtos.user.UserLoginDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterLoginDTO;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public UserLogin toEntity(RegisterLoginDTO dto) {
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(dto.getUserId());
        userLogin.setUsername(dto.getUsername());
        userLogin.setPassword(dto.getPassword());
        return userLogin;
    }

    public UserLoginDTO toDTO(UserLogin userLogin) {
        UserLoginDTO login = new UserLoginDTO();
        login.setName(userLogin.getUserInfo().getName());
        login.setUserType(userLogin.getUserInfo().getUserType());
        login.setAccessToken("access token generate successful");
        return login;
    }
}
