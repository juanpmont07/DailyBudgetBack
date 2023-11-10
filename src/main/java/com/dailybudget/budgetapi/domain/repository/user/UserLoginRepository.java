package com.dailybudget.budgetapi.domain.repository.user;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import reactor.core.publisher.Mono;

public interface UserLoginRepository {

    Mono<UserLogin> register(UserLogin userLogin);

}
