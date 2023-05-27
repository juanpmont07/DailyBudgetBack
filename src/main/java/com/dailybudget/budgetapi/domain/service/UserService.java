package com.dailybudget.budgetapi.domain.service;

import com.dailybudget.budgetapi.domain.models.UserInfo;
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

    public Mono<UserInfo> register(UserInfo userInfo){
       return userRepository.register(userInfo);
    }

    public Mono<UserInfo> getById(UUID id){
        return userRepository.getById(id);
    }
}
