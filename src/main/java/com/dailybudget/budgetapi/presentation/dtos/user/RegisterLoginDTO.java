package com.dailybudget.budgetapi.presentation.dtos.user;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterLoginDTO implements DTO {
    private UUID userId;
    private String username;
    private String password;
}
