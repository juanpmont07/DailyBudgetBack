package com.dailybudget.budgetapi.application.user.command;

import com.dailybudget.budgetapi.application.shared.command.Command;
import com.dailybudget.budgetapi.application.user.command.service.UserService;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserInfoMapper;
import com.dailybudget.budgetapi.domain.user.models.dto.RegisterUserDTO;
import com.dailybudget.budgetapi.domain.user.models.dto.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserInfo implements Command<RegisterUserDTO, UserInfoDTO> {

    private final UserInfoMapper userInfoMapper;
    private final UserService userService;

    @Override
    public Mono<UserInfoDTO> execute(RegisterUserDTO registerUserDTO){
       return userService.registerUserInfo(userInfoMapper.toDomain(registerUserDTO));
   }
}
