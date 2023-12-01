package com.dailybudget.budgetapi.domain.user.port;

import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import reactor.core.publisher.Mono;

public interface UserLoginRepository {

    Mono<UserLoginEntity> register(UserLogin userLogin);

}
