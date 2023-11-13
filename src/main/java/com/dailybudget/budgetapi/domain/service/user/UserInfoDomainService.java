package com.dailybudget.budgetapi.domain.service.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserInfoEntity;
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
