package com.dailybudget.budgetapi.infrastructure.user.adapters.repositories;

import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.user.models.entities.UserLogin;
import com.dailybudget.budgetapi.domain.user.port.UserLoginRepository;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserLoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserLoginRepositoryImpl implements UserLoginRepository {

    @Autowired
    private final UserLoginJpaRepository userLoginJpaRepository;

    @Autowired
    private final UserLoginMapper userLoginMapper;

    @Override
    public Mono<UserLoginEntity> register(UserLogin userLogin) {
        return Mono.fromCallable(()->userLoginJpaRepository.save(userLoginMapper.toEntity(userLogin)))
                .onErrorMap(ex->new DomainException(ex.getMessage(), StatusCode.USER_WAS_NOT_REGISTERED,ex));
    }
}
