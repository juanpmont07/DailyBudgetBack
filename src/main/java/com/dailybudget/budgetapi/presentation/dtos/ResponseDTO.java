package com.dailybudget.budgetapi.presentation.dtos;

import lombok.Data;

@Data
public class ResponseDTO implements DTO{

    private DTO dto;

    private String message;

    public ResponseDTO(DTO dto) {
        this.dto = dto;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }
}
