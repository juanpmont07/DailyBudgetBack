package com.dailybudget.budgetapi.infrastructure.adapters.entities.catagory;

import com.dailybudget.budgetapi.infrastructure.adapters.entities.user.UserInfoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    private UUID id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    private UserInfoEntity userInfo;
}
