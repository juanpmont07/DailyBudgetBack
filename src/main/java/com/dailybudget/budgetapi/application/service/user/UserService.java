package com.dailybudget.budgetapi.application.service.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.service.user.UserLoginDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.user.UserInfoMapper;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserLoginDomainService userLoginDomainService;
    @Autowired
    private final UserInfoDomainService userInfoDomainService;
    @Autowired
    private final UserInfoMapper userInfoMapper;

    public Mono<UserInfoDTO> registerUserInfo(UserInfo userInfo){
       return userInfoDomainService.getUserInfoById(userInfo.getId())
               .switchIfEmpty(userInfoDomainService.registerUserInfo(userInfo))
               .onErrorResume(user->Mono.error(new DomainException(StatusCode.USER_WAS_FOUND)));
    }

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userInfoDomainService.getUserInfoById(userLogin.getUserId())
               .switchIfEmpty(Mono.error(new DomainException(StatusCode.USER_WAS_NOT_FOUND)))
               .flatMap(userInfo-> userLoginDomainService.registerUserLogin(userLogin)
                   .map(userLoginR->{
                        userLoginR.setUserInfo(userInfoMapper.toEntity(userInfo));
                        return userLoginR;
                   })
               );
    }

}
