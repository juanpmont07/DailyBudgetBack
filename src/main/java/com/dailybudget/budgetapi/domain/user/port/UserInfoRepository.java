package com.dailybudget.budgetapi.domain.user.port;

import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserInfoRepository {

    Mono<UserInfoEntity> getById(UUID id);

    Mono<UserInfoEntity> register(UserInfo userInfo);

}
