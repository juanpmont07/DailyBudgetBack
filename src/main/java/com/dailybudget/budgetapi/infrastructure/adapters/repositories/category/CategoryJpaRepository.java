package com.dailybudget.budgetapi.infrastructure.adapters.repositories.category;

import com.dailybudget.budgetapi.domain.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryJpaRepository extends JpaRepository<Category, UUID> {
}