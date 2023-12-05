package com.dailybudget.budgetapi.domain.movements.service;

import com.dailybudget.budgetapi.domain.movements.models.entities.Movement;
import com.dailybudget.budgetapi.domain.movements.port.MovementsRepository;
import reactor.core.publisher.Mono;

public class CreateMovementService {

    private final MovementsRepository movementsRepository;

    public CreateMovementService(MovementsRepository movementsRepository) {
        this.movementsRepository = movementsRepository;
    }

    public Mono<Movement> execute(Movement movement){
        return movementsRepository.register(movement);
    }
}
