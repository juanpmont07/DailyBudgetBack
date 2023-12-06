package com.dailybudget.budgetapi.infrastructure.config;


import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import com.dailybudget.budgetapi.domain.fixedpayment.servicio.FixedPaymentService;
import com.dailybudget.budgetapi.domain.movements.port.MovementsRepository;
import com.dailybudget.budgetapi.domain.movements.service.CreateMovementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public FixedPaymentService fixedPaymentService(FixedPaymentRepository fixedPaymentRepository){
        return new FixedPaymentService(fixedPaymentRepository);
    }

    @Bean
    public CreateMovementService createMovementService(MovementsRepository movementsRepository){
        return new CreateMovementService(movementsRepository);
    }
}
