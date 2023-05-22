package com.dailybudget.budgetapi.domain.models;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private UUID userId;

}
