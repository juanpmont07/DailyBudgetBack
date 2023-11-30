package com.dailybudget.budgetapi.infrastructure.adapters.mappers;

import com.dailybudget.budgetapi.domain.models.budget.Category;
import com.dailybudget.budgetapi.domain.models.budget.FixedPayment;
import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import com.dailybudget.budgetapi.presentation.dtos.budget.RegisterFixedPaymentDTO;
import org.springframework.stereotype.Component;

@Component
public class FixedPaymentMapper {

    public FixedPayment toEntity(RegisterFixedPaymentDTO dto) {
        FixedPayment fixedPayment = new FixedPayment();
        fixedPayment.setId(dto.getId());
        fixedPayment.setDescription(dto.getDescription());
        fixedPayment.setPayDate(dto.getPay_date());
        fixedPayment.setValue(dto.getValue());
        Category category = new Category();
        category.setId(dto.getCategory_id());
        fixedPayment.setCategory(category);
        UserInfo user = new UserInfo();
        user.setId(dto.getUser_id());
        fixedPayment.setUser(user);
        return fixedPayment;
    }

}
