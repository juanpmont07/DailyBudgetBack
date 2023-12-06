package com.dailybudget.budgetapi.domain.user.models.dto;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class UserInfoDTO implements DTO {
    private UUID id;
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private String userType;
}