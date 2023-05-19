package com.dailyBudget.infrastructure.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RegisterUserDTO {
    private UUID id;
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private UUID userId;
}