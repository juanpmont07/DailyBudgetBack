package com.dailybudget.budgetapi.domain.repository.user;

import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FixedPaymentRepository {

    Mono<FixedPayment> register(FixedPayment fixedPayment);

    Flux<FixedPayment> getFixedPaymentsByUserId(UUID userId);
}
