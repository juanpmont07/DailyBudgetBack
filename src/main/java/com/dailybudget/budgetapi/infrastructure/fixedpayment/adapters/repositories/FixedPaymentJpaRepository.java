package com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.repositories;

import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.entities.FixedPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FixedPaymentJpaRepository extends JpaRepository<FixedPaymentEntity, UUID> {

    List<FixedPaymentEntity> findByUserId(UUID userId);
}
