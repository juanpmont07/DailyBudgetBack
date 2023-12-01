package com.dailybudget.budgetapi.infrastructure.user.adapters.repositories;

import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfoEntity, UUID> {
}
