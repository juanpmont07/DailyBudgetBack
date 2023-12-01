package com.dailybudget.budgetapi.application.shared.query;

import reactor.core.publisher.Mono;

public interface Query <P, T>{

    Mono<P> execute(T dto);
}
