package com.dailybudget.budgetapi.domain.models.budget;

import com.dailybudget.budgetapi.domain.models.user.UserInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "fixedpayment")
public class FixedPayment {

    @Id
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "pay_date", nullable = false)
    private Date payDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;
}
