package com.dailybudget.budgetapi.application.command.user;

import com.dailybudget.budgetapi.application.command.Command;
import com.dailybudget.budgetapi.application.service.user.UserService;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.user.UserInfoMapper;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterUserDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserInfo implements Command<RegisterUserDTO, UserInfoDTO> {

    @Autowired
    private final UserInfoMapper userInfoMapper;
    @Autowired
    private final UserService userService;

    @Override
    public Mono<UserInfoDTO> execute(RegisterUserDTO registerUserDTO){
       return userService.registerUserInfo(userInfoMapper.toDomain(registerUserDTO));
   }
}
