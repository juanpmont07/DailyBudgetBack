package com.dailybudget.budgetapi.infrastructure.adapters.repositories;

import com.dailybudget.budgetapi.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {
}
