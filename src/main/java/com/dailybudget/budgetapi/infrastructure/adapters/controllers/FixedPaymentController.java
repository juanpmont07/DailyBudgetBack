package com.dailybudget.budgetapi.infrastructure.adapters.controllers;

import com.dailybudget.budgetapi.application.command.budget.CreateFixedPayment;
import com.dailybudget.budgetapi.presentation.dtos.ResponseDTO;
import com.dailybudget.budgetapi.presentation.dtos.budget.RequestRegisterPaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fixed_payment")
@RequiredArgsConstructor
public class FixedPaymentController {

    @Autowired
    private CreateFixedPayment createFixedPayment;

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
}
