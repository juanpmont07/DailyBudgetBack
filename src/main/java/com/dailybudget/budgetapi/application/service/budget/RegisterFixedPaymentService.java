package com.dailybudget.budgetapi.application.service.budget;

import com.dailybudget.budgetapi.application.command.budget.CreateFixedPayment;
import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import com.dailybudget.budgetapi.domain.service.FixedPaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterFixedPaymentService {

    @Autowired
    private final FixedPaymentService fixedPaymentService;

    private static final Logger log = LoggerFactory.getLogger(CreateFixedPayment.class);


    public Flux<FixedPayment> register(Flux<FixedPayment> fixedPayments, UUID userId){
        log.info("aqui 2"+ userId.toString());
      return fixedPaymentService.removeDuplicates(fixedPayments, userId).flatMap(fixedPaymentService::register);
    }
}
