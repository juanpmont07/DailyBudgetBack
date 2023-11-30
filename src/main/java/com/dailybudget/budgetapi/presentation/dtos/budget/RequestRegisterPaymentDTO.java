package com.dailybudget.budgetapi.presentation.dtos.budget;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.util.List;

@Data
public class RequestRegisterPaymentDTO implements DTO {

    private List<RegisterFixedPaymentDTO> registerFixedPaymentDTO;

    private String idUsuario;

    public RequestRegisterPaymentDTO() {
    }

    public RequestRegisterPaymentDTO(List<RegisterFixedPaymentDTO> registerFixedPaymentDTO, String idUsuario) {
        this.registerFixedPaymentDTO = registerFixedPaymentDTO;
        this.idUsuario = idUsuario;
    }
}
