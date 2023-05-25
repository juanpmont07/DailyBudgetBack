package com.dailybudget.budgetapi.domain.service;

import com.dailybudget.budgetapi.domain.models.User;
import com.dailybudget.budgetapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> register(User user){
       return userRepository.register(user);
    }

    public Mono<User> getById(UUID id){
        return userRepository.getById(id);
    }
}
