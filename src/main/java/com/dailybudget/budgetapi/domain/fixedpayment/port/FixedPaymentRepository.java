package com.dailybudget.budgetapi.domain.fixedpayment.port;

import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.entities.FixedPayment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FixedPaymentRepository {

    Mono<FixedPayment> register(FixedPayment fixedPayment);

    Flux<FixedPayment> getFixedPaymentsByUserId(UUID userId);
}
