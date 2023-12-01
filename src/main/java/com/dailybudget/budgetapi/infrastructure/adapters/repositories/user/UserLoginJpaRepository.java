package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserLoginJpaRepository extends JpaRepository<UserLoginEntity, UUID> {
}
