package com.dailybudget.budgetapi.domain.service.user;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.repository.user.UserLoginRepository;
import reactor.core.publisher.Mono;

public class UserLoginDomainService {

    private final UserLoginRepository userLoginRepository;

    public UserLoginDomainService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userLoginRepository.register(userLogin);
    }

}