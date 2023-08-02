package com.dailybudget.budgetapi.domain.models.budget;

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

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;

}
