package com.dailybudget.budgetapi.presentation.dtos;

import lombok.Data;

@Data
public class GenericResponseDTO implements DTO{
    private String message;
    private String errorMessage;
}
