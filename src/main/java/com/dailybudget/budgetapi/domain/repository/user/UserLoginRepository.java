package com.dailybudget.budgetapi.domain.repository.user;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserLoginEntity;
import reactor.core.publisher.Mono;

public interface UserLoginRepository {

    Mono<UserLoginEntity> register(UserLogin userLogin);

}
