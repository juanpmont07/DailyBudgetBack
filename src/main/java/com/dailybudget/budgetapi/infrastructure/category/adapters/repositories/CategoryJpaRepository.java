package com.dailybudget.budgetapi.infrastructure.category.adapters.repositories;

import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, UUID> {

    List<CategoryEntity> findByUserInfoId(UUID userId);

}