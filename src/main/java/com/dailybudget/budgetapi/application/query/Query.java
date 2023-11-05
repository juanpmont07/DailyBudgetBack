package com.dailybudget.budgetapi.application.query;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import reactor.core.publisher.Mono;

public interface Query <P, T>{

    Mono<P> execute(T dto);
}
