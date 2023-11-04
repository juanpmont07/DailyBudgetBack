package com.dailybudget.budgetapi.application.command;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Command<P extends DTO, T extends DTO> {

   Mono<T> execute(P dto);
}
