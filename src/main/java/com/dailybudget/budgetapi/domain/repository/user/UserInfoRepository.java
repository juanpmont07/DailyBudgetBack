package com.dailybudget.budgetapi.domain.repository.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserInfoRepository {

    Mono<UserInfoDTO> getById(UUID id);

    Mono<UserInfoDTO> register(UserInfo userInfo);

}
