package com.dailybudget.budgetapi.domain.movements.models.dtos;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestMovementsDTO implements DTO {

    List<RegisterMovementsDTO> registerMovementsDTOS;

}
