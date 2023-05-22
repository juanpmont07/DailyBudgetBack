package com.dailybudget.budgetapi.application.command;

import com.dailybudget.budgetapi.application.service.user.RegisterUser;
import com.dailybudget.budgetapi.domain.models.User;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.UserMapper;
import com.dailybudget.budgetapi.presentation.dtos.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CreateUser implements Command<RegisterUserDTO, User>{


    @Autowired
    private UserMapper userMapper;

    private final RegisterUser registerUser;
    @Autowired
    public CreateUser(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @Override
    public Flux<User> execute(RegisterUserDTO registerUserDTO){
       return registerUser.register(userMapper.toEntity(registerUserDTO)).flux();
   }
}
