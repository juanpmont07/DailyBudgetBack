package com.dailybudget.budgetapi.infrastructure.adapters.entities.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserInfoEntity {

    @Id
    private UUID id;
    private String name;
    private BigDecimal salary;
    @Column(name = "saving_rule")
    private String savingRule;
    @Column(name = "user_type")
    private String userType;
}
