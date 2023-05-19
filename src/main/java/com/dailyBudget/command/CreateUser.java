package com.dailyBudget.command;

import com.dailyBudget.infrastructure.dtos.RegisterUserDTO;
import reactor.core.publisher.Mono;

public class CreateUser {

   public Mono<String> execute(RegisterUserDTO registerUserDTO){
       return Mono.just(registerUserDTO.toString());
   }

}
