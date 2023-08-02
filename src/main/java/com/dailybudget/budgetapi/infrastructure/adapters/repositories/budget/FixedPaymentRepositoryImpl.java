package com.dailybudget.budgetapi.infrastructure.adapters.repositories.budget;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import com.dailybudget.budgetapi.domain.repository.user.FixedPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class FixedPaymentRepositoryImpl implements FixedPaymentRepository {

    @Autowired
    private final FixedPaymentJpaRepository fixedPaymentJpaRepository;

    @Override
    public Mono<FixedPayment> register(FixedPayment fixedPayment) {
       return Mono.fromCallable(()->fixedPaymentJpaRepository.save(fixedPayment))
                .onErrorResume(error->Mono.error(new DomainException("Error try to register the fixedPayment",error)));
    }

    @Override
    public Flux<FixedPayment> getFixedPaymentsByUserId(UUID userId) {
        return fixedPaymentJpaRepository.findByUserId(userId);
    }

}
