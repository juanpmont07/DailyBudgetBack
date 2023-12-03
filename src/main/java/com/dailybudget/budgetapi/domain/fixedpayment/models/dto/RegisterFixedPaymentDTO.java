package com.dailybudget.budgetapi.domain.fixedpayment.models.dto;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class RegisterFixedPaymentDTO implements DTO {
    private UUID id;
    private String description;
    private UUID category_id;
    private BigDecimal value;
    private UUID user_id;
    private Date pay_date;
}
