package com.dailybudget.budgetapi.application.command.budget;

import com.dailybudget.budgetapi.application.command.CommandFlux;
import com.dailybudget.budgetapi.presentation.dtos.GenericResponseDTO;
import com.dailybudget.budgetapi.presentation.dtos.budget.RegisterFixedPaymentDTO;
import com.dailybudget.budgetapi.presentation.dtos.user.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateFixedPayment  implements CommandFlux<RegisterFixedPaymentDTO, GenericResponseDTO> {

    @Override
    public Mono<GenericResponseDTO> execute(Flux<RegisterFixedPaymentDTO> registerFixedPaymentDTOFlux){
        return Mono.just(new GenericResponseDTO());
    }

}
