package com.dailybudget.budgetapi.infrastructure.adapters.repositories.budget;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import com.dailybudget.budgetapi.domain.repository.user.FixedPaymentRepository;
import com.dailybudget.budgetapi.domain.service.FixedPaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(FixedPaymentService.class);

    @Override
    public Mono<FixedPayment> register(FixedPayment fixedPayment) {
        log.info(fixedPayment.getDescription(), fixedPayment.getId());
       return Mono.fromCallable(()->fixedPaymentJpaRepository.save(fixedPayment))
                .onErrorResume(error->Mono.error(new DomainException("Error try to register the fixedPayment",error)));
    }

    @Override
    public Flux<FixedPayment> getFixedPaymentsByUserId(UUID userId) {
        return Flux.fromIterable(fixedPaymentJpaRepository.findByUserId(userId));
    }

}
