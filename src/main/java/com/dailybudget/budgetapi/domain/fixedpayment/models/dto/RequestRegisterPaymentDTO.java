package com.dailybudget.budgetapi.domain.fixedpayment.models.dto;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RequestRegisterPaymentDTO implements DTO {

    private List<RegisterFixedPaymentDTO> registerFixedPaymentDTO;

    private String idUsuario;
}
