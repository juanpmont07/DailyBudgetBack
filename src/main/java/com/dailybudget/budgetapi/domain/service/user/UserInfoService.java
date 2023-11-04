package com.dailybudget.budgetapi.domain.service.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    @Autowired
    private final UserInfoRepository userInfoRepository;

    public Mono<UserInfo> registerUserInfo(UserInfo userInfo){
       return userInfoRepository.register(userInfo);
    }

    public Mono<UserInfo> getUserInfoById(UUID id){
        return userInfoRepository.getById(id);
    }

}
