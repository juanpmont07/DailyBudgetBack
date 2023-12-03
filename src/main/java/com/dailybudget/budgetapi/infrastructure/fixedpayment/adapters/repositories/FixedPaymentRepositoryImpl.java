package com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.repositories;

import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.shared.exceptions.DomainException;
import com.dailybudget.budgetapi.domain.shared.utils.StatusCode;
import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.entities.FixedPaymentEntity;
import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import com.dailybudget.budgetapi.domain.fixedpayment.servicio.FixedPaymentService;
import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.mappers.FixedPaymentMapper;
import com.dailybudget.budgetapi.infrastructure.user.adapters.mappers.UserLoginMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class FixedPaymentRepositoryImpl implements FixedPaymentRepository {

    @Autowired
    private final FixedPaymentJpaRepository fixedPaymentJpaRepository;

    @Autowired
    private final FixedPaymentMapper fixedPaymentMapper;
    private static final Logger log = LoggerFactory.getLogger(FixedPaymentService.class);

    @Override
    public Mono<FixedPayment> register(FixedPayment fixedPayment) {
        log.info(fixedPayment.getDescription(), fixedPayment.getId());
       return Mono.fromCallable(()->fixedPaymentMapper.toDomain(fixedPaymentJpaRepository.save(fixedPaymentMapper.toEntity(fixedPayment))))
                .onErrorResume(error->Mono.error(new DomainException(error.getMessage(), StatusCode.USER_WAS_NOT_REGISTERED)));
    }

    public Flux<FixedPayment> getFixedPaymentsByUserId(UUID userId) {
        return Flux.fromIterable(fixedPaymentJpaRepository.findByUserId(userId))
                .map(fixedPaymentMapper::toDomain);
    }

}
