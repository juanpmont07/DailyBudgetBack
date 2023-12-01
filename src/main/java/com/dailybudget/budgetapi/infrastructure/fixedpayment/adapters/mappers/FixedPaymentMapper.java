package com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.mappers;

import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.entities.FixedPayment;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.domain.fixedpayment.models.dto.RegisterFixedPaymentDTO;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class FixedPaymentMapper {

    public FixedPayment toEntity(RegisterFixedPaymentDTO dto) {
        FixedPayment fixedPayment = new FixedPayment();
        fixedPayment.setId(dto.getId());
        fixedPayment.setDescription(dto.getDescription());
        fixedPayment.setPayDate(dto.getPay_date());
        fixedPayment.setValue(dto.getValue());
        CategoryEntity category = new CategoryEntity();
        category.setId(dto.getCategory_id());
        fixedPayment.setCategory(category);
        UserInfoEntity user = new UserInfoEntity();
        user.setId(dto.getUser_id());
        fixedPayment.setUser(user);
        return fixedPayment;
    }

}
