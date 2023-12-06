package com.dailybudget.budgetapi.infrastructure.movements.adapters.repositories;

import com.dailybudget.budgetapi.infrastructure.movements.adapters.entities.MovementsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public interface MovementsJpaRepository extends JpaRepository<MovementsEntity, UUID> {


    @Transactional
    @Query(value = "INSERT INTO movements(id, description, category_id, date, fixed_payment_id, value, user_id) " +
            "VALUES (:id, :description, :category_id, :date, :fixed_payment_id, :value, :user_id) RETURNING *", nativeQuery = true)
    MovementsEntity insertMovement(UUID id, String description, UUID category_id, Date date, UUID fixed_payment_id, BigDecimal value, UUID user_id);


}
