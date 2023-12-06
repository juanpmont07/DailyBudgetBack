package com.dailybudget.budgetapi.domain.movements.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterMovementsDTO {

    private UUID idFixedPayment;

    private String description;

    private Date date;

    private UUID idCategory;

    private BigDecimal value;

    private UUID idUser;

}
