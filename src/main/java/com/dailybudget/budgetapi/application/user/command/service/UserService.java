package com.dailybudget.budgetapi.application.user.command.service;

import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import com.dailybudget.budgetapi.domain.user.service.UserLoginDomainService;
import com.dailybudget.budgetapi.domain.user.service.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserInfoMapper;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserLoginMapper;
import com.dailybudget.budgetapi.domain.user.models.dto.UserInfoDTO;
import com.dailybudget.budgetapi.domain.user.models.dto.UserLoginDTO;
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
    @Autowired
    private final UserLoginMapper userLoginMapper;

    public Mono<UserInfoDTO> registerUserInfo(UserInfo userInfo){
       return userInfoDomainService.getUserInfoById(userInfo.getId())
               .switchIfEmpty(userInfoDomainService.registerUserInfo(userInfo)).map(userInfoMapper::toDTO)
               .onErrorResume(user->Mono.error(new DomainException(StatusCode.USER_WAS_FOUND)));
    }

    public Mono<UserLoginDTO> registerUserLogin(UserLogin userLogin){
        return userInfoDomainService.getUserInfoById(userLogin.getUserId())
               .switchIfEmpty(Mono.error(new DomainException(StatusCode.USER_WAS_NOT_FOUND)))
                .flatMap(userInfo -> userLoginDomainService.registerUserLogin(userLogin)
                        .map(userLoginEntity -> { userLoginEntity.setUserInfo(userInfo);
                            return userLoginMapper.toDTO(userLoginEntity);
                        }));

    }

}
