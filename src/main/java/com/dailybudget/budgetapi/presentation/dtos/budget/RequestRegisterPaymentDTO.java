package com.dailybudget.budgetapi.presentation.dtos.budget;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;
import reactor.core.publisher.Flux;

@Data
public class RequestRegisterPaymentDTO implements DTO {

    private Flux<RegisterFixedPaymentDTO> registerFixedPaymentDTO;

    private String idUsuario;
}
