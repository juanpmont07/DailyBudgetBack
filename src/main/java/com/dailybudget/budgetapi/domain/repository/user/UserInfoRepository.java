package com.dailybudget.budgetapi.domain.repository.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserInfoEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserInfoRepository {

    Mono<UserInfoEntity> getById(UUID id);

    Mono<UserInfoEntity> register(UserInfo userInfo);

}
