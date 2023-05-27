package com.dailybudget.budgetapi.domain.repository;

import com.dailybudget.budgetapi.domain.models.UserInfo;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository {

    Mono<UserInfo> getById(UUID id);

    Mono<UserInfo> register(UserInfo userInfo);

}
