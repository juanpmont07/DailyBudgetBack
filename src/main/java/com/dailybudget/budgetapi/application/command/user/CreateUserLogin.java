package com.dailybudget.budgetapi.application.command.user;

import com.dailybudget.budgetapi.application.command.Command;
import com.dailybudget.budgetapi.application.service.user.UserService;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.user.UserLoginMapper;
import com.dailybudget.budgetapi.presentation.dtos.user.UserLoginDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterLoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserLogin implements Command<RegisterLoginDTO, UserLoginDTO> {

    @Autowired
    private final UserLoginMapper userLoginMapper;
    @Autowired
    private final UserService registerLogin;

    @Override
    public Mono<UserLoginDTO> execute(RegisterLoginDTO dto) {
        return registerLogin.registerUserLogin(userLoginMapper.toEntity(dto)).map(userLoginMapper::toDTO);
    }
}