package com.dailybudget.budgetapi.application.service.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.service.user.UserLoginDomainService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.utils.ErrorCode;
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

    public Mono<UserInfo> registerUserInfo(UserInfo userInfo){
       return  userInfoDomainService.getUserInfoById(userInfo.getId()).
               flatMap(userExist -> Mono.error(new DomainException(ErrorCode.USER_WAS_FOUND))).
               switchIfEmpty(userInfoDomainService.registerUserInfo(userInfo))
               .cast(UserInfo.class);
    }

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userInfoDomainService.getUserInfoById(userLogin.getUserId())
               .switchIfEmpty(Mono.error(new DomainException(ErrorCode.USER_WAS_NOT_FOUND)))
               .flatMap(userInfo-> userLoginDomainService.registerUserLogin(userLogin)
                   .map(userLoginR->{
                        userLoginR.setUserInfo(userInfo);
                        return userLoginR;
                   })
               .cast(UserLogin.class));
    }

}
