package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.domain.repository.user.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserInfoRepositoryImpl implements UserInfoRepository {

    @Autowired
    private final UserInfoJpaRepository userInfoJpaRepository;

    @Override
    public Mono<UserInfo> getById(UUID id) {
        Optional<UserInfo> userOptional = userInfoJpaRepository.findById(id);
        return userOptional.map(Mono::just).orElseGet(Mono::empty);
    }

    @Override
    public Mono<UserInfo> register(UserInfo userInfo) {
        return Mono.fromCallable(()->userInfoJpaRepository.save(userInfo))
                .onErrorMap(ex->new DomainException("Error registering the user",ex));
    }
}