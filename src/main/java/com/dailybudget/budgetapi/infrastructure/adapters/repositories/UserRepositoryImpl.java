package com.dailybudget.budgetapi.infrastructure.adapters.repositories;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.User;
import com.dailybudget.budgetapi.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Mono<User> getById(UUID id) {
        Optional<User> userOptional = userJpaRepository.findById(id);
        if (userOptional.isPresent()) {
            return Mono.just(userOptional.get());
        } else {
            return Mono.empty();
        }
    }

    @Override
    public Mono<User> register(User user) {
        try {
            User savedUser = userJpaRepository.save(user);
            return Mono.just(savedUser);
        } catch (Exception ex) {
            throw new DomainException("Error registering the user", ex);
        }
    }
}