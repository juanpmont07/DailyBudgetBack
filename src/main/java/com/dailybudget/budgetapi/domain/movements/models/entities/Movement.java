package com.dailybudget.budgetapi.domain.movements.models.entities;

import com.dailybudget.budgetapi.domain.category.models.entities.Category;
import com.dailybudget.budgetapi.domain.fixedpayment.models.entites.FixedPayment;
import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Movement {

    private final UUID id;

    private final String description;

    private final Date date;

    private final Category category;

    private final BigDecimal value;

    private final UserInfo user;

    private final UUID idFixedPayment;

    public Movement(UUID id, String description, Date date, Category category, BigDecimal value, UserInfo user, UUID idFixedPayment) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.category = category;
        this.value = value;
        this.user = user;
        this.idFixedPayment = idFixedPayment;
    }


    public static Movement create(String description, Date payDate, Category category, BigDecimal value, UserInfo user, UUID idFixedPayment) {
        return new Movement(UUID.randomUUID(), description, payDate, category,value, user, idFixedPayment);
    }

    public static Movement rebuild(UUID id, String description, Date payDate, Category category, BigDecimal value, UserInfo user,  UUID idFixedPayment) {
        return new Movement(id, description, payDate, category,value, user, idFixedPayment);
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public UserInfo getUser() {
        return user;
    }

    public UUID getIdFixedPayment() {
        return idFixedPayment;
    }

    private static Movement createMovementByFixedPayment(Date date, FixedPayment fixedPayment){
           return create(fixedPayment.getDescription(), date, fixedPayment.getCategory(),
                   fixedPayment.getValue(), fixedPayment.getUser(), fixedPayment.getId());

    }

    public static Movement createMovement(String description, Date date, Category category, BigDecimal value, UserInfo user, FixedPayment fixedPayment){
        if(fixedPayment == null){
            return new Movement(UUID.randomUUID(), description, date, category,value, user, null);
        }
        return createMovementByFixedPayment(date, fixedPayment);
    }
}