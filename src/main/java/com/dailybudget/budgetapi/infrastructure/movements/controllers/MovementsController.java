package com.dailybudget.budgetapi.infrastructure.movements.controllers;


import com.dailybudget.budgetapi.application.movements.command.CreateMovements;
import com.dailybudget.budgetapi.domain.movements.models.dtos.RequestMovementsDTO;
import com.dailybudget.budgetapi.presentation.dtos.ResponseDTO;
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
@RequestMapping("/movements")
@RequiredArgsConstructor
public class MovementsController {

    @Autowired
    private final CreateMovements createMovements;

    @PostMapping("/register")
    public Mono<ResponseEntity<ResponseDTO>> register(@RequestBody RequestMovementsDTO dto) {
        return createMovements.execute(dto)
                .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(response)))
                .onErrorResume(throwable -> {
                    String errorMessage = throwable.getMessage();
                    HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                    return Mono.just(ResponseEntity.status(errorStatus).body(new ResponseDTO(errorMessage)));
                });
    }

}
