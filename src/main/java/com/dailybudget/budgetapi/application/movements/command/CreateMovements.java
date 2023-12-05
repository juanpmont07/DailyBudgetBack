package com.dailybudget.budgetapi.application.movements.command;


import com.dailybudget.budgetapi.application.shared.command.Command;
import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import com.dailybudget.budgetapi.domain.movements.models.dtos.RequestMovementsDTO;
import com.dailybudget.budgetapi.domain.movements.models.entities.Movement;
import com.dailybudget.budgetapi.domain.movements.service.CreateMovementService;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CreateMovements implements Command<RequestMovementsDTO, String> {

    @Autowired
    private final CreateMovementService createMovementService;


    @Autowired
    private final FixedPaymentRepository fixedPaymentRepository;

    public Mono<String> execute(RequestMovementsDTO request) {
        try {
            List<Movement> movementList = createListMovement(request);
            return Flux.fromIterable(movementList)
                    .flatMap(createMovementService::execute)
                    .then(Mono.just("Movimientos creados exitosamente"));
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    private List<Movement> createListMovement(RequestMovementsDTO request) {
        return request.getRegisterMovementsDTOS().stream()
                .map(mov -> {
                    Category category = Category.rebuild(mov.getIdCategory());
                    UserInfo userInfo = UserInfo.rebuild(mov.getIdUser());
                    FixedPayment fixedPayment = mov.getIdFixedPayment() == null ? null : fixedPaymentRepository.getFixedPaymentsById(mov.getIdFixedPayment()).block();
                    return Movement.createMovement(mov.getDescription(), mov.getDate(), category, mov.getValue(), userInfo, fixedPayment);
                })
                .toList();
    }

}
