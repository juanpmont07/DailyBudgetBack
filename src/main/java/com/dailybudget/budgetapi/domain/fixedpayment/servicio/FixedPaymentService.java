package com.dailybudget.budgetapi.domain.fixedpayment.servicio;

import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FixedPaymentService {

    @Autowired
    private final FixedPaymentRepository fixedPaymentRepository;

    private static final Logger log = LoggerFactory.getLogger(FixedPaymentService.class);

    public Mono<FixedPayment> register(FixedPayment fixedPayments){
        log.info("Inicia registro de costos fijos" + fixedPayments.getId());
        return fixedPaymentRepository.register(fixedPayments);
    }

    public Flux<FixedPayment> removeDuplicates(Flux<FixedPayment> fixedPaymentFlux, UUID userId) {
        return fixedPaymentRepository.getFixedPaymentsByUserId(userId)
                .collectList()
                .flatMapMany(userFixedPayments -> {
                    if (userFixedPayments.size() > 1) {
                        return fixedPaymentFlux
                                .filter(fixedPayment -> isDistinct(fixedPayment, userFixedPayments));
                    } else {
                        return fixedPaymentFlux;
                    }
                });
    }

    private boolean isDistinct(FixedPayment fixedPayment, List<FixedPayment> userFixedPayments) {
        return userFixedPayments
                .stream()
                .noneMatch(fixedPayment1 ->
                        fixedPayment.getDescription().equalsIgnoreCase(fixedPayment1.getDescription()) &&
                                fixedPayment.getCategory().getId().equals(fixedPayment1.getCategory().getId())
                );
    }

}
