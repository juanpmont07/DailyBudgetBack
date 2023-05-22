package com.dailyBudget.budgetapi.command;

import com.dailyBudget.budgetapi.infrastructure.dtos.DTO;
import reactor.core.publisher.Flux;

public interface Command<P extends DTO, T> {

   Flux<T> execute(P dto);
}
