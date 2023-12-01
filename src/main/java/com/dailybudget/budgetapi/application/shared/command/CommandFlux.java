package com.dailybudget.budgetapi.application.shared.command;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommandFlux<P extends DTO, T> {
    Mono<T> execute(Flux<P> dto);
}
