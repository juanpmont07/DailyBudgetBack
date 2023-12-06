package com.dailybudget.budgetapi.infrastructure.user.adapters.repositories;

import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserLoginJpaRepository extends JpaRepository<UserLoginEntity, UUID> {
}
