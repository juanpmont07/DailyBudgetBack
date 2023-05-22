package com.dailybudget.budgetapi.infrastructure.adapters.controllers;

import lombok.Data;

@Data
public class User {

    public String name;
    public String lastName;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
