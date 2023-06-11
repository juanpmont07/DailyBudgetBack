package com.dailybudget.budgetapi.domain.models.user;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserInfo {

    @Id
    private UUID id;
    private String name;
    private BigDecimal salary;

    @Column(name = "saving_rule")
    private String savingRule;
    @Column(name = "user_type")
    private String userType;
}
