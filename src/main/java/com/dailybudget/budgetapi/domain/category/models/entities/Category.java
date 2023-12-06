package com.dailybudget.budgetapi.domain.category.models.entities;

import com.dailybudget.budgetapi.domain.user.models.entities.UserInfo;

import java.util.UUID;

public class Category {

    private UUID id;
    private String name;
    private UserInfo user;

    public String getName() {
        return name;
    }

    public UUID getUserId() {
        return user.getId();
    }

    public UUID getId() {
        return id;
    }

    public UserInfo getUserInfo(){
        return user;
    }

    private Category(UUID id, String name, UserInfo user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    private Category(String name, UserInfo userInfo) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.user = userInfo;
    }

    private Category(UUID id) {
        this.id = id;
    }


    public static Category create(String name, UserInfo userInfo) {
       return new Category(name, userInfo);
    }

    public static Category rebuild(UUID id, String name, UserInfo userInfo) {
        return new Category(id, name, userInfo);
    }

    public static Category rebuild(UUID id) {
        return new Category(id);
    }
}