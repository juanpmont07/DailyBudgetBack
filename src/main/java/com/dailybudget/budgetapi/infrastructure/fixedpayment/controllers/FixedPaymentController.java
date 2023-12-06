package com.dailybudget.budgetapi.infrastructure.fixedpayment.controllers;

import com.dailybudget.budgetapi.application.fixedpayment.command.CreateFixedPayment;
import com.dailybudget.budgetapi.application.fixedpayment.query.ConsultFixedPayment;
import com.dailybudget.budgetapi.domain.category.models.dto.ConsultCategoryDTO;
import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.presentation.dtos.ResponseDTO;
import com.dailybudget.budgetapi.domain.fixedpayment.models.dto.RequestRegisterPaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/fixed_payment")
@RequiredArgsConstructor
public class FixedPaymentController {

    @Autowired
    private CreateFixedPayment createFixedPayment;

    @Autowired
    private ConsultFixedPayment consultFixedPayment;

    @PostMapping("/register")
    public Mono<ResponseEntity<ResponseDTO>> register(@RequestBody RequestRegisterPaymentDTO dto) {
        return createFixedPayment.execute(dto)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(response)))
                .onErrorResume(throwable -> {
                    String errorMessage = throwable.getMessage();
                    HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                    return Mono.just(ResponseEntity.status(errorStatus).body(new ResponseDTO(errorMessage)));
                });
    }

    @GetMapping
    public Mono<ResponseEntity<List<FixedPayment>>> getFixedPaymentByUserId(@RequestParam("userId") UUID userId) {
        return consultFixedPayment.execute(userId)
                .map(fixedPayments -> ResponseEntity.status(HttpStatus.OK)
                        .body(fixedPayments));
    }
}
