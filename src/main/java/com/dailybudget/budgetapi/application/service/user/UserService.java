package com.dailybudget.budgetapi.application.service.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.service.user.UserLoginService;
import com.dailybudget.budgetapi.domain.service.user.UserInfoService;
import com.dailybudget.budgetapi.domain.utils.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserLoginService userLoginService;
    @Autowired
    private final UserInfoService userInfoService;

    public Mono<UserInfo> registerUserInfo(UserInfo userInfo){
       return  userInfoService.getUserInfoById(userInfo.getId()).
               flatMap(userExist -> Mono.error(new DomainException(ErrorCode.USER_WAS_FOUND))).
               switchIfEmpty(userInfoService.registerUserInfo(userInfo))
               .cast(UserInfo.class);
    }

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userInfoService.getUserInfoById(userLogin.getUserId())
               .switchIfEmpty(Mono.error(new DomainException(ErrorCode.USER_WAS_NOT_FOUND)))
               .flatMap(userInfo->userLoginService.registerUserLogin(userLogin)
                   .map(userLoginR->{
                        userLoginR.setUserInfo(userInfo);
                        return userLoginR;
                   })
               .cast(UserLogin.class));
    }

}
