package com.dailyBudget.budgetapi.command;

import com.dailyBudget.budgetapi.infrastructure.dtos.RegisterUserDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateUser {

    public CreateUser() {
    }

    public Mono<String> execute(RegisterUserDTO registerUserDTO){
       return Mono.just(registerUserDTO.toString());
   }

}
