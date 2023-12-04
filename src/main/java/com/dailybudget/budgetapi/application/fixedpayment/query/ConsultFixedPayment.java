package com.dailybudget.budgetapi.application.fixedpayment.query;


import com.dailybudget.budgetapi.application.shared.query.Query;
import com.dailybudget.budgetapi.domain.category.models.dto.ConsultCategoryDTO;
import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsultFixedPayment  implements Query<List<FixedPayment>, UUID> {

    private final FixedPaymentRepository fixedPaymentRepository;
    
    @Override
    public Mono<List<FixedPayment>> execute(UUID idUser) {
        return fixedPaymentRepository.getFixedPaymentsByUserId(idUser).collectList();
    }
}
