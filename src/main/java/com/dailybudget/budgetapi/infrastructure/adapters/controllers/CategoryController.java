package com.dailybudget.budgetapi.infrastructure.adapters.controllers;

import com.dailybudget.budgetapi.application.command.category.CreateCategory;
import com.dailybudget.budgetapi.application.query.category.ConsultCategory;
import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import com.dailybudget.budgetapi.presentation.dtos.ResponseDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.RegisterCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategory createCategory;
    private final ConsultCategory consultCategory;

    @GetMapping("/version")
    public Mono<String> version(){
        return Mono.just("1.0.0");
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<ResponseDTO>> registerCategory(@RequestBody RegisterCategoryDTO registerCategoryDTO) {
        return createCategory.execute(registerCategoryDTO)
                .map(categoryDTO -> ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(categoryDTO)))
                .onErrorResume(DomainException.class, domainException ->
                        Mono.just(ResponseEntity.status(domainException.getErrorCode().getHttpStatus())
                                .body(new ResponseDTO(domainException)))
                );
    }

    @GetMapping
    public Mono<ResponseEntity<ResponseDTO>> getCategoryByUserId(@RequestParam("userId") UUID userId) {
        return consultCategory.execute(userId)
                .map(categories -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(categories.toArray(new ConsultCategoryDTO[0]))))
                .onErrorResume(DomainException.class, domainException ->
                        Mono.just(ResponseEntity.status(domainException.getErrorCode().getHttpStatus())
                                .body(new ResponseDTO(domainException)))
                );
    }
}