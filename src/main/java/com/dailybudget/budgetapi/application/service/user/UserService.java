package com.dailybudget.budgetapi.application.service.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.service.UserServiceD;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserServiceD userServiceD;

    public Mono<UserInfo> registerUserInfo(UserInfo userInfo){
       return  userServiceD.getUserInfoById(userInfo.getId()).
               flatMap(userExist -> Mono.error(new DomainException("User exist"))).
               switchIfEmpty(userServiceD.registerUserInfo(userInfo))
               .cast(UserInfo.class);
    }

    public Mono<UserLogin> registerUserLogin(UserLogin userLogin){
        return userServiceD.getUserInfoById(userLogin.getUserId())
                .flatMap(userInfo->userServiceD.registerUserLogin(userLogin)
                        .map(userLoginR->{
                            userLoginR.setUserInfo(userInfo);
                            return userLoginR;
                        })
                .switchIfEmpty(Mono.error(new DomainException("User not is register in the application"))
                .cast(UserLogin.class)));
    }

}
