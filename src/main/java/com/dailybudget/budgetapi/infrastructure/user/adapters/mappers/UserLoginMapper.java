package com.dailybudget.budgetapi.infrastructure.user.adapters.mappers;

import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import com.dailybudget.budgetapi.domain.user.models.dto.UserLoginDTO;
import com.dailybudget.budgetapi.domain.user.models.dto.RegisterLoginDTO;
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
