package com.dailybudget.budgetapi.application.budget.command;

import com.dailybudget.budgetapi.application.shared.command.Command;
import com.dailybudget.budgetapi.application.budget.command.service.RegisterFixedPaymentService;
import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.mappers.FixedPaymentMapper;
import com.dailybudget.budgetapi.domain.fixedpayment.models.dto.RegisterFixedPaymentDTO;
import com.dailybudget.budgetapi.domain.fixedpayment.models.dto.RequestRegisterPaymentDTO;
import lombok.RequiredArgsConstructor;
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
