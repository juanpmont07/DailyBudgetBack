package com.dailybudget.budgetapi.infrastructure.category.adapters.entities;

import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    private UUID id = UUID.randomUUID();
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    private UserInfoEntity userInfo;
}
