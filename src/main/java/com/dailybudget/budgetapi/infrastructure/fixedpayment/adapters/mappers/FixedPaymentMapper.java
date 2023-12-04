package com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.mappers;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import com.dailybudget.budgetapi.infrastructure.category.adapters.entities.CategoryEntity;
import com.dailybudget.budgetapi.infrastructure.category.adapters.mappers.CategoryMapper;
import com.dailybudget.budgetapi.infrastructure.fixedpayment.adapters.entities.FixedPaymentEntity;
import com.dailybudget.budgetapi.domain.fixedpayment.models.dto.RegisterFixedPaymentDTO;
import com.dailybudget.budgetapi.infrastructure.user.adapters.entities.UserInfoEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FixedPaymentMapper {

    public FixedPayment toDomain(RegisterFixedPaymentDTO dto) {
        Category category = Category.rebuild(dto.getCategory_id());
        UserInfo userInfo = UserInfo.rebuild(dto.getUser_id());
        return FixedPayment.create(dto.getDescription(), dto.getPay_date(), category, dto.getValue(), userInfo);
    }

    public FixedPaymentEntity toEntity(RegisterFixedPaymentDTO dto) {
        FixedPaymentEntity fixedPayment = new FixedPaymentEntity();
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


        public FixedPaymentEntity toEntity(FixedPayment domain) {
        FixedPaymentEntity fixedPayment = new FixedPaymentEntity();
        if (domain!=null) {
            fixedPayment.setId(domain.getId());
            fixedPayment.setDescription(domain.getDescription());
            fixedPayment.setPayDate(domain.getPayDate());
            fixedPayment.setValue(domain.getValue());
            CategoryEntity category = new CategoryEntity();
            category.setId(domain.getCategory().getId());
            fixedPayment.setCategory(category);
            UserInfoEntity user = new UserInfoEntity();
            user.setId(domain.getUser().getId());
            fixedPayment.setUser(user);
        }
        return fixedPayment;
    }

    public FixedPayment toDomain(FixedPaymentEntity entity) {
        Category category = new CategoryMapper().toDomain(entity.getCategory());
        UserInfo userInfo = UserInfo.rebuild(entity.getUser().getId(), entity.getUser().getName(), entity.getUser().getSalary(), entity.getUser().getSavingRule(), entity.getUser().getUserType());
        return FixedPayment.rebuild(entity.getId(), entity.getDescription(), entity.getPayDate(), category, entity.getValue(), userInfo);
    }
}
