package com.dailybudget.budgetapi.domain.user.port;

import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import reactor.core.publisher.Mono;

public interface UserLoginRepository {

    Mono<UserLogin> register(UserLogin userLogin);
 }
