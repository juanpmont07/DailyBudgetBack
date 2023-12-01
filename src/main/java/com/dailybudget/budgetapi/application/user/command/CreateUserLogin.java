package com.dailybudget.budgetapi.application.user.command;

import com.dailybudget.budgetapi.application.shared.command.Command;
import com.dailybudget.budgetapi.application.user.command.service.UserService;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserLoginMapper;
import com.dailybudget.budgetapi.domain.user.models.dto.UserLoginDTO;
import com.dailybudget.budgetapi.domain.user.models.dto.RegisterLoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserLogin implements Command<RegisterLoginDTO, UserLoginDTO> {

    private final UserLoginMapper userLoginMapper;
    private final UserService registerLogin;

    @Override
    public Mono<UserLoginDTO> execute(RegisterLoginDTO dto) {
        return registerLogin.registerUserLogin(userLoginMapper.toDomain(dto));
    }
}