package com.dailybudget.budgetapi.presentation.dtos.category;

import com.dailybudget.budgetapi.presentation.dtos.DTO;
import lombok.Data;
import java.util.UUID;

@Data
public class CategoryDTO implements DTO {
    private UUID idCategory;
    private String categoryName;
    private String userName;
    private String savingRule;
}