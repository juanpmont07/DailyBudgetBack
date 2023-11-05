package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import com.dailybudget.budgetapi.domain.repository.user.UserLoginRepository;
import com.dailybudget.budgetapi.domain.utils.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserLoginRepositoryImpl implements UserLoginRepository {

    @Autowired
    private final UserLoginJpaRepository userLoginJpaRepository;

    @Override
    public Mono<UserLogin> register(UserLogin userLogin) {
        return Mono.fromCallable(()->userLoginJpaRepository.save(userLogin))
                .onErrorMap(ex->new DomainException(ErrorCode.USER_WAS_NOT_REGISTERED,ex));
    }
}
