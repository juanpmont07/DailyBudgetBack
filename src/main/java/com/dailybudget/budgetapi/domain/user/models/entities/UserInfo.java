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

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSavingRule() {
        return savingRule;
    }

    public void setSavingRule(String savingRule) {
        this.savingRule = savingRule;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
