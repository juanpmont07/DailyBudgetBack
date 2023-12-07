package com.dailybudget.budgetapi.domain.user.models.dto;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements DTO {
    private UUID userId;
    private String username;
    private String password;
}
