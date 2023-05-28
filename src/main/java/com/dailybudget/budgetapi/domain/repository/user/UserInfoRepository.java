package com.dailybudget.budgetapi.domain.repository.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserInfoRepository {

    Mono<UserInfo> getById(UUID id);

    Mono<UserInfo> register(UserInfo userInfo);

}
