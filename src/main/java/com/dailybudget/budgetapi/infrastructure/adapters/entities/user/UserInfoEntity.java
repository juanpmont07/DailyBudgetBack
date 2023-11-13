package com.dailybudget.budgetapi.infrastructure.adapters.entities.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Data
@Entity
@Table(name = "users")
public class UserInfoEntity {

    @Id
    private UUID id;
    private String name = EMPTY;
    private BigDecimal salary = BigDecimal.ZERO;
    @Column(name = "saving_rule")
    private String savingRule = EMPTY;
    @Column(name = "user_type")
    private String userType = EMPTY;
}
