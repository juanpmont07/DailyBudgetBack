package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.domain.models.user.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserLoginJpaRepository extends JpaRepository<UserLogin, UUID> {
}
