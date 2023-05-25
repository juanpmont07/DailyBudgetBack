package com.dailybudget.budgetapi.presentation.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UserDTO implements DTO{
    private UUID id;
    private String name;
    private BigDecimal salary;
    private String savingRule;
}