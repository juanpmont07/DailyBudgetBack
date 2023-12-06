package com.dailybudget.budgetapi.infrastructure.category.adapters.entities;

import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "category")
@JsonIgnoreProperties("userInfo")
public class CategoryEntity {

    @Id
    private UUID id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    private UserInfoEntity userInfo;
}
