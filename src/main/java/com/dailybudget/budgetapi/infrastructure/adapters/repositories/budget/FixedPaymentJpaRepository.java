package com.dailybudget.budgetapi.infrastructure.adapters.repositories.budget;

import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

public interface FixedPaymentJpaRepository extends JpaRepository<FixedPayment, UUID> {

    Flux<FixedPayment> findByUserId(UUID userId);
}
