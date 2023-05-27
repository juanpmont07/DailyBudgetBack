package com.dailybudget.budgetapi.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "userinfo")
public class UserInfo {

    @Id
    private UUID id;
    private String name;
    private BigDecimal salary;

    @Column(name = "saving_rule")
    private String savingRule;

}
