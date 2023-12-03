package com.dailybudget.budgetapi.domain.user.models.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class UserInfo {

    private UUID id;
    private String name;
    private BigDecimal salary;
    private String savingRule;
    private String userType;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getSavingRule() {
        return savingRule;
    }

    public String getUserType() {
        return userType;
    }

    private UserInfo(UUID id, String name, BigDecimal salary, String savingRule, String userType) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.savingRule = savingRule;
        this.userType = userType;
    }

    public UserInfo(UUID id) {
        this.id = id;
    }

    public static UserInfo create(String name, BigDecimal salary, String savingRule, String userType) {
        return new UserInfo(UUID.randomUUID(), name, salary, savingRule, userType);
    }

    public static UserInfo rebuild(UUID id, String name, BigDecimal salary, String savingRule, String userType) {
        return new UserInfo(id, name, salary, savingRule, userType);
    }

    public static UserInfo rebuild(UUID id) {
        return new UserInfo(id);
    }
}
