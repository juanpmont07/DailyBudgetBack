package com.dailybudget.budgetapi.domain.service;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import com.dailybudget.budgetapi.domain.repository.user.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceD {

    @Autowired
    private final UserInfoRepository userInfoRepository;
    @Autowired
    private final UserLoginRepository userLoginRepository;

    public Mono<UserInfo> registerUserInfo(UserInfo userInfo){
       return userInfoRepository.register(userInfo);
    }

    public Mono<UserInfo> getUserInfoById(UUID id){
        return userInfoRepository.getById(id);
    }

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userLoginRepository.register(userLogin);
    }

}
