package com.dailybudget.budgetapi.presentation.dtos.category;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ConsultCategoryDTO implements DTO {
    private UUID idCategory;
    private String categoryName;
}
