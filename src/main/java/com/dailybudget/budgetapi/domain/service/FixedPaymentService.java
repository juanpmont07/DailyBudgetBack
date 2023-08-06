package com.dailybudget.budgetapi.domain.service;

import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import com.dailybudget.budgetapi.domain.repository.user.FixedPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FixedPaymentService {

    @Autowired
    private final FixedPaymentRepository fixedPaymentRepository;

    public Mono<FixedPayment> register(FixedPayment fixedPayments){
        return fixedPaymentRepository.register(fixedPayments);
    }

    public Flux<FixedPayment> removeDuplicates(Flux<FixedPayment> fixedPaymentFlux, UUID userId){
         Flux<FixedPayment> userFixedPayments = fixedPaymentRepository.getFixedPaymentsByUserId(userId);
         return fixedPaymentFlux
                .filter(fixedPayment -> userFixedPayments
                        .any(fixedPayment1 -> fixedPayment.getDescription().equalsIgnoreCase(fixedPayment1.getDescription()) &&
                                fixedPayment.getCategory().getId().equals(fixedPayment1.getCategory().getId()))
                        .blockOptional()
                        .isEmpty()
                );
    }

}
