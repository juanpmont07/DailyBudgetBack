package com.dailyBudget.budgetapi.command;

import com.dailyBudget.budgetapi.infrastructure.dtos.DTO;
import com.dailyBudget.budgetapi.infrastructure.dtos.RegisterUserDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CreateUser implements Command<RegisterUserDTO, String>{

    public CreateUser() {
    }

    @Override
    public Flux<String> execute(RegisterUserDTO registerUserDTO){
       return Flux.just(registerUserDTO.toString());
   }
}
