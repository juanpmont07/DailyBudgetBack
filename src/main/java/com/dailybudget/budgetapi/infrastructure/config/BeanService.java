package com.dailybudget.budgetapi.infrastructure.config;


import com.dailybudget.budgetapi.domain.category.port.CategoryRepository;
import com.dailybudget.budgetapi.domain.category.service.CategoryDomainService;
import com.dailybudget.budgetapi.domain.fixedpayment.port.FixedPaymentRepository;
import com.dailybudget.budgetapi.domain.fixedpayment.servicio.FixedPaymentService;
import com.dailybudget.budgetapi.domain.movements.port.MovementsRepository;
import com.dailybudget.budgetapi.domain.movements.service.CreateMovementService;
import com.dailybudget.budgetapi.domain.user.port.UserInfoRepository;
import com.dailybudget.budgetapi.domain.user.port.UserLoginRepository;
import com.dailybudget.budgetapi.domain.user.service.UserInfoDomainService;
import com.dailybudget.budgetapi.domain.user.service.UserLoginDomainService;
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

    @Bean
    public UserInfoDomainService userInfoDomainService(UserInfoRepository userInfoRepository){
        return new UserInfoDomainService(userInfoRepository);
    }

    @Bean
    public UserLoginDomainService userLoginDomainService(UserLoginRepository userLoginRepository){
        return new UserLoginDomainService(userLoginRepository);
    }

    @Bean
    public CategoryDomainService categoryDomainService(CategoryRepository categoryRepository){
        return new CategoryDomainService(categoryRepository);
    }
}
