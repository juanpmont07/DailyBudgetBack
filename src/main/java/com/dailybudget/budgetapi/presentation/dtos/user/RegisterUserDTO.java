package com.dailybudget.budgetapi.presentation.dtos.user;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RegisterUserDTO implements DTO {
    private UUID id = UUID.randomUUID();
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private String userType;
    private String username;
    private String password;
}