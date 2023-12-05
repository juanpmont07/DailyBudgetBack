package com.dailybudget.budgetapi.domain.movements.port;

import com.dailybudget.budgetapi.domain.movements.models.entities.Movement;
import reactor.core.publisher.Mono;

public interface MovementsRepository {

    Mono<Movement> register(Movement movement);

}
