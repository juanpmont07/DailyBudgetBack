package com.dailybudget.budgetapi.infrastructure.user.adapters.mappers;

import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import com.dailybudget.budgetapi.domain.user.models.dto.UserLoginDTO;
import com.dailybudget.budgetapi.domain.user.models.dto.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {

    public UserLogin toDomain(LoginRequest dto) {
       return UserLogin.rebuild(dto.getUserId(), dto.getUsername(), dto.getPassword());
    }

    public UserLogin toDomain(UserLoginEntity dto) {
        return UserLogin.rebuild(dto.getUserId(), dto.getUsername(), dto.getPassword());
    }

    public UserLoginDTO toDTO(UserLogin userLogin) {
        UserLoginDTO login = new UserLoginDTO();
        login.setName(userLogin.getNameUserInfo());
        login.setUserType(userLogin.getTypeUserInfo());
        login.setAccessToken("access token generate successful");
        return login;
    }

    public UserLoginEntity toEntity(UserLogin domain) {
        UserLoginEntity userLogin = new UserLoginEntity();
        userLogin.setUserId(domain.getIdUserInfo());
        userLogin.setUsername(domain.getUsername());
        userLogin.setPassword(domain.getPassword());
        return userLogin;
    }

}
