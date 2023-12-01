package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.repository.user.UserLoginRepository;
import com.dailybudget.budgetapi.domain.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserLoginEntity;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.user.UserLoginMapper;
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
