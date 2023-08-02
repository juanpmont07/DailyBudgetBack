package com.dailybudget.budgetapi.presentation.dtos.budget;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class RegisterFixedPaymentDTO implements DTO {
    private UUID id;
    private String description;
    private UUID category_id;
    private BigDecimal value;
    private UUID user_id;
}
