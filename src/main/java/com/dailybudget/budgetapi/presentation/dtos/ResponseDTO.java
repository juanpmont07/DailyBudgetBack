package com.dailybudget.budgetapi.presentation.dtos;

import com.dailybudget.budgetapi.domain.exceptions.DomainException;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Data
public class ResponseDTO implements DTO{

    private List<DTO> dto = new ArrayList<>();

    private String message = EMPTY;

    public ResponseDTO(DTO... dto) {
        this.dto = Arrays.asList(dto);
    }

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(DomainException domainException) {
        this.message = domainException.getErrorCode().getMessage()+
                " : "+ domainException.getMessage();
    }
}
