package com.dailybudget.budgetapi.domain.fixedpayment.models.entites;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class FixedPayment {

    private UUID id;

    private String description;

    private Date payDate;

    private Category category;

    private BigDecimal value;

    private UserInfo user;

    private FixedPayment(UUID id, String description, Date payDate, Category category, BigDecimal value, UserInfo user) {
        this.id = id;
        this.description = description;
        this.payDate = payDate;
        this.category = category;
        this.value = value;
        this.user = user;
    }

    public static FixedPayment create(String description, Date payDate, Category category, BigDecimal value, UserInfo user) {
        return new FixedPayment(UUID.randomUUID(), description, payDate, category,value, user);
    }

    public static FixedPayment rebuild(UUID id, String description, Date payDate, Category category, BigDecimal value, UserInfo user) {
        return new FixedPayment(id, description, payDate, category,value, user);
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public UserInfo getUser() {
        return user;
    }

    public Date getPayDate() {
        return payDate;
    }

    public BigDecimal getValue() {
        return value;
    }
}
