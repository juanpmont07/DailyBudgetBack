package com.dailybudget.budgetapi.application.command;

import com.dailybudget.budgetapi.application.service.user.RegisterUser;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.UserInfoMapper;
import com.dailybudget.budgetapi.presentation.dtos.user.RegisterUserDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateUser implements Command<RegisterUserDTO, UserInfoDTO>{

    @Autowired
    private UserInfoMapper userInfoMapper;

    private final RegisterUser registerUser;
    @Autowired
    public CreateUser(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @Override
    public Mono<UserInfoDTO> execute(RegisterUserDTO registerUserDTO){
       return registerUser.register(userInfoMapper.toEntity(registerUserDTO)).map(user -> userInfoMapper.toDTO(user));
   }
}
