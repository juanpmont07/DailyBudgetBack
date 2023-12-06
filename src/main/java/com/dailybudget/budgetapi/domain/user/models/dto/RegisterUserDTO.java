package com.dailybudget.budgetapi.domain.user.models.dto;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RegisterUserDTO implements DTO {
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private String userType;
    private String username;
    private String password;
}