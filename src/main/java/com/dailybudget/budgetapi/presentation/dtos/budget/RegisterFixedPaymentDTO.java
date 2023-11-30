package com.dailybudget.budgetapi.presentation.dtos.budget;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
public class RegisterFixedPaymentDTO implements DTO {
    private UUID id;
    private String description;
    private UUID category_id;
    private BigDecimal value;
    private UUID user_id;
    private Date pay_date;

    public RegisterFixedPaymentDTO() {
    }

    public RegisterFixedPaymentDTO(UUID id, String description, UUID category_id, BigDecimal value, UUID user_id, Date pay_date) {
        this.id = id;
        this.description = description;
        this.category_id = category_id;
        this.value = value;
        this.user_id = user_id;
        this.pay_date = pay_date;
    }
}
