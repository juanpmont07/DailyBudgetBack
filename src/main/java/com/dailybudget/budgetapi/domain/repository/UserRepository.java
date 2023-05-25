package com.dailybudget.budgetapi.domain.repository;

import com.dailybudget.budgetapi.domain.models.User;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository {

    Mono<User> getById(UUID id);

    Mono<User> register(User user);

}
