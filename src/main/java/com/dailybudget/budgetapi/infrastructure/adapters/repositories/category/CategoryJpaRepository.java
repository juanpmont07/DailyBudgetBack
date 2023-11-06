package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, UUID> {

    List<CategoryEntity> findByUserInfoId(UUID userId);

}