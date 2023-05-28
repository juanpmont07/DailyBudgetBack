package com.dailybudget.budgetapi.presentation.dtos.user;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RegisterUserDTO implements DTO {
    private UUID id = UUID.fromString("49ee246d-e2a1-4d5d-84b1-6f5165ffbbe3");
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private String userType;
}