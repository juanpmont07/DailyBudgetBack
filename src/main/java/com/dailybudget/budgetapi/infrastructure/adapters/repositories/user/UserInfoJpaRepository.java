package com.dailybudget.budgetapi.infrastructure.adapters.repositories.user;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfo, UUID> {
}
