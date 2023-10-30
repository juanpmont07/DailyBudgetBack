package com.dailybudget.budgetapi.domain.models.category;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    private UUID id;
    private String name;
    @Column(name = "user_id")
    private UUID userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private UserInfo userInfo;
}