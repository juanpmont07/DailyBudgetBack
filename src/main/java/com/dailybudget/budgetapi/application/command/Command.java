package com.dailybudget.budgetapi.application.command;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import reactor.core.publisher.Flux;

public interface Command<P extends DTO, T> {

   Flux<T> execute(P dto);
}
