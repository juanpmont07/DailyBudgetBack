package com.dailybudget.budgetapi.infrastructure.adapters.controllers;

import com.dailybudget.budgetapi.application.command.category.CreateCategory;
import com.dailybudget.budgetapi.application.query.category.ConsultCategory;
import com.dailybudget.budgetapi.presentation.dtos.ResponseDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.CategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.ConsultCategoryDTO;
import com.dailybudget.budgetapi.presentation.dtos.category.RegisterCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private final CreateCategory createCategory;

    @Autowired
    private final ConsultCategory consultCategory;

    @GetMapping("/version")
    public Mono<String> version(){
        return Mono.just("1.0.0");
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<ResponseDTO>> registerCategory(@RequestBody RegisterCategoryDTO registerCategoryDTO) {
        return createCategory.execute(registerCategoryDTO)
                .map(categoryDTO -> ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(categoryDTO)))
                .onErrorResume(throwable -> {
                    String errorMessage = throwable.getMessage();
                    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(errorMessage)));
                });
    }

    @GetMapping
    public Mono<ResponseEntity<ResponseDTO>> getCategoryByUserId(@RequestParam("userId") UUID userId) {
        return consultCategory.execute(userId)
                .map(categories -> ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDTO(categories.toArray(new ConsultCategoryDTO[0]))))
                .onErrorResume(throwable -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ResponseDTO(throwable.getMessage())))
                );
    }
}