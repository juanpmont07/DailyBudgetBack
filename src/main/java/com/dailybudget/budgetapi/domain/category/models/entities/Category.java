package com.dailybudget.budgetapi.domain.category.models.entities;

import java.util.UUID;

public class Category {

    private String name;
    private UUID userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}