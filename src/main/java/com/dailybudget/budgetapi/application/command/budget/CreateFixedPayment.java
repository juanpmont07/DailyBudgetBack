package com.dailybudget.budgetapi.application.command.budget;

import com.dailybudget.budgetapi.application.command.Command;
import com.dailybudget.budgetapi.application.service.budget.RegisterFixedPaymentService;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.FixedPaymentMapper;
import com.dailybudget.budgetapi.presentation.dtos.GenericResponseDTO;
import com.dailybudget.budgetapi.presentation.dtos.budget.RequestRegisterPaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateFixedPayment  implements Command<RequestRegisterPaymentDTO, GenericResponseDTO> {

    @Autowired
    private final RegisterFixedPaymentService registerFixedPaymentService;

    @Autowired
    private final FixedPaymentMapper fixedPaymentMapper;

    @Override
    public Mono<GenericResponseDTO> execute(RequestRegisterPaymentDTO request){
        UUID uuid = UUID.fromString(request.getIdUsuario());
        return registerFixedPaymentService.register(request.getRegisterFixedPaymentDTO().map(fixedPaymentMapper::toEntity), uuid)
                .collectList()
                .map(response -> new GenericResponseDTO("Success"));
    }
}
