package com.dailybudget.budgetapi.infrastructure.movements.adapters.repositories;

import com.dailybudget.budgetapi.domain.fixedpayment.servicio.FixedPaymentService;
import com.dailybudget.budgetapi.domain.movements.models.entities.Movement;
import com.dailybudget.budgetapi.domain.movements.port.MovementsRepository;
import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.movements.adapters.mappers.MovementsMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class MovementsRepositoryImpl implements MovementsRepository {

    @Autowired
    private final MovementsJpaRepository movementsJpaRepository;

    @Autowired
    private final MovementsMapper movementsMapper;
    private static final Logger log = LoggerFactory.getLogger(FixedPaymentService.class);

    @Override
    public Mono<Movement> register(Movement movement) {
        log.info(movement.getDescription(), movement.getId());
       return Mono.fromCallable(()->movementsJpaRepository.insertMovement(movement.getId(), movement.getDescription() ,movement.getCategory().getId(),
                       movement.getDate(), movement.getIdFixedPayment(), movement.getValue(), movement.getUser().getId()))
               .map(movementsMapper::toDomain)
                .onErrorResume(error->Mono.error(new DomainException(error.getMessage(), StatusCode.USER_WAS_NOT_REGISTERED)));
    }


}
