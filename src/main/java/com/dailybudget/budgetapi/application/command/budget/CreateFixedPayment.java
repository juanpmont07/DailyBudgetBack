package com.dailybudget.budgetapi.application.command.budget;

import com.dailybudget.budgetapi.application.command.Command;
import com.dailybudget.budgetapi.application.service.budget.RegisterFixedPaymentService;
import com.dailybudget.budgetapi.domain.service.FixedPaymentService;
import com.dailybudget.budgetapi.infrastructure.adapters.mappers.FixedPaymentMapper;
import com.dailybudget.budgetapi.presentation.dtos.budget.RegisterFixedPaymentDTO;
import com.dailybudget.budgetapi.presentation.dtos.budget.RequestRegisterPaymentDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateFixedPayment  implements Command<RequestRegisterPaymentDTO, String> {

    @Autowired
    private final RegisterFixedPaymentService registerFixedPaymentService;

    @Autowired
    private final FixedPaymentMapper fixedPaymentMapper;
    @Override
    public Mono<String> execute(RequestRegisterPaymentDTO request){
        UUID uuid = UUID.fromString(request.getIdUsuario());
        Flux<RegisterFixedPaymentDTO> registerFixedPaymentDTOFlux = Flux.fromIterable(request.getRegisterFixedPaymentDTO());
        return registerFixedPaymentService.register(registerFixedPaymentDTOFlux.map(fixed -> {
            fixed.setId(UUID.randomUUID());
           return fixedPaymentMapper.toEntity(fixed);
        }), uuid)
                .collectList()
                .map(response -> "Success");
    }
}
