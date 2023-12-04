package com.dailybudget.budgetapi.infrastructure.config;


import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import com.dailybudget.budgetapi.domain.fixedpayment.servicio.FixedPaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanService {

    @Bean
    public FixedPaymentService fixedPaymentService(FixedPaymentRepository fixedPaymentRepository){
        return new FixedPaymentService(fixedPaymentRepository);
    }
}
