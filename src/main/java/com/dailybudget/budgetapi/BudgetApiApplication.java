package com.dailybudget.budgetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BudgetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetApiApplication.class, args);
	}

}
