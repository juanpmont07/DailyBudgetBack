package com.dailybudget.budgetapi.domain.user.models.dto;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

@Data
public class UserLoginDTO implements DTO {
    private String name;
    private String userType;
    private String accessToken;
}
