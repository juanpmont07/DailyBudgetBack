package com.dailybudget.budgetapi.domain.user.models.entities;

import java.util.UUID;

public class UserLogin {

    private UserInfo userInfo;
    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UUID getIdUserInfo(){
        return this.userInfo.getId();
    }

    public String getNameUserInfo(){
        return this.userInfo.getName();
    }

    public String getTypeUserInfo(){
        return this.userInfo.getUserType();
    }


    private UserLogin(UserInfo userInfo, String username, String password) {
        this.userInfo = userInfo;
        this.username = username;
        this.password = password;
    }

    public static UserLogin rebuild(UUID userId, String username, String password) {
        UserInfo userInfo1 = UserInfo.rebuild(userId);
        return new UserLogin(userInfo1, username, password);
    }
    }
