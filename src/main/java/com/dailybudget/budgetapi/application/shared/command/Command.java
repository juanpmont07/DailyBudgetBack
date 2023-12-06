package com.dailybudget.budgetapi.application.shared.command;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import reactor.core.publisher.Mono;

public interface Command<P extends DTO, T> {

   Mono<T> execute(P dto);
}

