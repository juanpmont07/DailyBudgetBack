package com.dailybudget.budgetapi.domain.service.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;


public class UserInfoDomainService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoDomainService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public Mono<UserInfoDTO> registerUserInfo(UserInfo userInfo){
       return userInfoRepository.register(userInfo);
    }

    public Mono<UserInfoDTO> getUserInfoById(UUID id){
        return userInfoRepository.getById(id);
    }

}
