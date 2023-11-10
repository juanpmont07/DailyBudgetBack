package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import com.dailybudget.budgetapi.domain.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.user.UserInfoMapper;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @Autowired
    private final UserInfoJpaRepository userInfoJpaRepository;

    @Autowired
    private final UserInfoMapper userInfoMapper;

    @Override
    public Mono<UserInfoDTO> getById(UUID id) {
        return Mono.fromCallable(()->userInfoJpaRepository.findById(id))
                .flatMap(user -> Mono.justOrEmpty(user.map(userInfoMapper::toDTO)))
                .onErrorMap(ex->new DomainException(ex.getMessage(), StatusCode.ERROR_CONSULTING_THE_USER, ex));
    }

    @Override
    public Mono<UserInfoDTO> register(UserInfo userInfo) {
        return Mono.fromCallable(()->userInfoJpaRepository.save(userInfoMapper.toEntity(userInfo)))
                .map(userInfoMapper::toDTO)
                .onErrorMap(ex->new DomainException(ex.getMessage(), StatusCode.USER_WAS_NOT_REGISTERED, ex));
    }
}