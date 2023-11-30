package com.dailybudget.budgetapi.domain.service.user;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.repository.user.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserLoginService {

    @Autowired
    private final UserLoginRepository userLoginRepository;

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userLoginRepository.register(userLogin);
    }

}