package com.dailybudget.budgetapi.presentation.dtos;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ResponseDTO implements DTO{

    private List<DTO> dto;

    private String message;

    public ResponseDTO(DTO... dto) {
        this.dto = Arrays.asList(dto);;
    }

    public ResponseDTO(String message) {
        this.message = message;
    }
}
