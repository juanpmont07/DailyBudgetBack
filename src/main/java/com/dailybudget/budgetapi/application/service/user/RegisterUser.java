package com.dailybudget.budgetapi.application.service.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.User;
import com.dailybudget.budgetapi.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RegisterUser {

    private final UserService userService;

    @Autowired
    public RegisterUser(UserService userService) {
        this.userService = userService;
    }

    public Mono<User> register(User user){
       return  userService.getById(user.getId()).
               flatMap(userExist -> Mono.error(new DomainException("User exist"))).
               switchIfEmpty(userService.register(user))
               .cast(User.class);
    }

}
