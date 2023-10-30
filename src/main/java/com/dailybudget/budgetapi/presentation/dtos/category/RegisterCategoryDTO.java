package com.dailybudget.budgetapi.presentation.dtos.category;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterCategoryDTO implements DTO {

    private UUID id = UUID.randomUUID();
    private String name;
    private UUID userId;
}