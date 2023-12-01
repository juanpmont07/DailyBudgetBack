package com.dailybudget.budgetapi.domain.user.service;

import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import com.dailybudget.budgetapi.domain.user.port.UserLoginRepository;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import reactor.core.publisher.Mono;

public class UserLoginDomainService {

    private final UserLoginRepository userLoginRepository;

    public UserLoginDomainService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public Mono<UserLoginEntity> registerUserLogin(UserLogin userLogin){
        return userLoginRepository.register(userLogin);
    }

}