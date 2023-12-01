package com.dailybudget.budgetapi.domain.user.service;

import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.domain.user.port.UserInfoRepository;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;


public class UserInfoDomainService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoDomainService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public Mono<UserInfoEntity> registerUserInfo(UserInfo userInfo){
       return userInfoRepository.register(userInfo);
    }

    public Mono<UserInfoEntity> getUserInfoById(UUID id){
        return userInfoRepository.getById(id);
    }

}
