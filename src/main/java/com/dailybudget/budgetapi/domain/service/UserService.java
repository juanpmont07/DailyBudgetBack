package com.dailybudget.budgetapi.domain.service;

import com.dailybudget.budgetapi.domain.models.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {


    public Mono<User> register(User user){
        return Mono.just(user);
    }

    public Mono<User> getById(UUID id){
        return  Mono.error(new RuntimeException("User not found"));
      //  return Mono.just(new User());
    }
}
